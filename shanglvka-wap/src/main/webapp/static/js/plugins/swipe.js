function Swipe(m, e) {
	var f = function() {
	};
	var u = function(E) {
		setTimeout(E || f, 0)
	};
	var x = navigator.userAgent.toLowerCase();
	var D = {
		addEventListener : !!window.addEventListener,
		touch : ("ontouchstart" in window) || window.DocumentTouch
				&& document instanceof DocumentTouch,
		transitions : (function(E) {
			var G = [ "transitionProperty", "WebkitTransition",
					"MozTransition", "OTransition", "msTransition" ];
			for ( var F in G) {
				if (E.style[G[F]] !== undefined) {
					return true
				}
			}
			return false
		})(document.createElement("swipe"))
	};
	if (!m) {
		return
	}
	var v = false;
	var c = m.children[0];
	var s, d, r, g;
	e = e || {};
	var k = parseInt(e.startSlide, 10) || 0;
	var w = e.speed || 300;
	e.continuous = (e.continuous !== undefined) ? e.continuous : true;
	e.disableTouch = (e.disableTouch !== undefined) ? e.disableTouch : false;
	function n() {
		s = c.children;
		g = s.length;
		if (s.length < 2) {
			e.continuous = false
		}
		if (D.transitions && e.continuous && s.length < 3) {
			c.appendChild(s[0].cloneNode(true));
			c.appendChild(c.children[1].cloneNode(true));
			s = c.children;
			v = true
		}
		d = new Array(s.length);
		r = m.getBoundingClientRect().width || m.offsetWidth;
		c.style.width = (s.length * r) + "px";
		var F = s.length;
		while (F--) {
			var E = s[F];
			E.style.width = r + "px";
			E.setAttribute("data-index", F);
			if (D.transitions) {
				E.style.left = (F * -r) + "px";
				if (x.indexOf("gt-") != -1) {
					E.style.webkitBackfaceVisibility = "hidden"
				}
				q(F, k > F ? -r : (k < F ? r : 0), 0)
			}
		}
		if (e.continuous && D.transitions) {
			q(i(k - 1), -r, 0);
			q(i(k + 1), r, 0)
		}
		if (!D.transitions) {
			c.style.left = (k * -r) + "px"
		}
		m.style.visibility = "visible"
	}
	function o() {
		if (e.continuous) {
			a(k - 1)
		} else {
			if (k) {
				a(k - 1)
			}
		}
	}
	function p() {
		if (e.continuous) {
			a(k + 1)
		} else {
			if (k < s.length - 1) {
				a(k + 1)
			}
		}
	}
	function i(E) {
		return (s.length + (E % s.length)) % s.length
	}
	function a(J, F) {
		if (k == J) {
			return
		}
		if (D.transitions) {
			var I = Math.abs(k - J) / (k - J);
			if (e.continuous) {
				var E = I;
				I = -d[i(J)] / r;
				if (I !== E) {
					J = -I * s.length + J
				}
			}
			var H = Math.abs(k - J) - 1;
			while (H--) {
				q(i((J > k ? J : k) - H - 1), r * I, 0)
			}
			J = i(J);
			q(k, r * I, F || w);
			q(J, 0, F || w);
			if (e.continuous) {
				q(i(J - I), -(r * I), 0)
			}
		} else {
			J = i(J);
			j(k * -r, J * -r, F || w)
		}
		k = J;
		var G = k;
		if (v && (k > 1)) {
			G = k - 2
		}
		u(e.callback && e.callback(G, s[k]))
	}
	function q(E, G, F) {
		l(E, G, F);
		d[E] = G
	}
	function l(F, I, H) {
		var E = s[F];
		var G = E && E.style;
		if (!G) {
			return
		}
		G.webkitTransitionDuration = G.MozTransitionDuration = G.msTransitionDuration = G.OTransitionDuration = G.transitionDuration = H
				+ "ms";
		if (x.indexOf("gt-") != -1) {
			G.webkitTransform = "translateX(" + I + "px)"
		} else {
			G.webkitTransform = "translate(" + I + "px,0)translateZ(0)"
		}
		G.msTransform = G.MozTransform = G.OTransform = "translateX(" + I
				+ "px)"
	}
	function j(I, H, E) {
		if (!E) {
			c.style.left = H + "px";
			return
		}
		var G = +new Date;
		var F = setInterval(function() {
			var K = +new Date - G;
			if (K > E) {
				c.style.left = H + "px";
				if (C) {
					z()
				}
				var J = k;
				if (v && (k > 1)) {
					J = k - 2
				}
				e.transitionEnd && e.transitionEnd.call(event, J, s[k]);
				clearInterval(F);
				return
			}
			c.style.left = (((H - I) * (Math.floor((K / E) * 100) / 100)) + I)
					+ "px"
		}, 4)
	}
	var C = e.auto || 0;
	var y;
	function z() {
		y = setTimeout(p, C)
	}
	function t() {
		C = 0;
		clearTimeout(y)
	}
	var h = {};
	var A = {};
	var B;
	var b = {
		handleEvent : function(E) {
			switch (E.type) {
			case "touchstart":
				this.start(E);
				break;
			case "touchmove":
				this.move(E);
				break;
			case "touchend":
				u(this.end(E));
				break;
			case "webkitTransitionEnd":
			case "msTransitionEnd":
			case "oTransitionEnd":
			case "otransitionend":
			case "transitionend":
				u(this.transitionEnd(E));
				break;
			case "resize":
				u(n.call());
				break
			}
			if (e.stopPropagation) {
				E.stopPropagation()
			}
		},
		start : function(E) {
			if (e.disableTouch) {
				return
			}
			var F = E.touches[0];
			h = {
				x : F.pageX,
				y : F.pageY,
				time : +new Date
			};
			B = undefined;
			c.addEventListener("touchmove", this, false);
			c.addEventListener("touchend", this, false)
		},
		move : function(E) {
			if (e.disableTouch) {
				return
			}
			if (E.touches.length > 1 || E.scale && E.scale !== 1) {
				return
			}
			if (e.disableScroll) {
				E.preventDefault()
			}
			var F = E.touches[0];
			A = {
				x : F.pageX - h.x,
				y : F.pageY - h.y
			};
			if (!e.continuous
					&& ((!k && A.x > 0) || (k == s.length - 1 && A.x < 0))) {
				return
			}
			if (typeof B == "undefined") {
				B = !!(B || Math.abs(A.x) < Math.abs(A.y))
			}
			if (!B) {
				E.preventDefault();
				t();
				if (e.continuous) {
					l(i(k - 1), A.x + d[i(k - 1)], 0);
					l(k, A.x + d[k], 0);
					l(i(k + 1), A.x + d[i(k + 1)], 0)
				} else {
					A.x = A.x
							/ ((!k && A.x > 0 || k == s.length - 1 && A.x < 0) ? (Math
									.abs(A.x)
									/ r + 1)
									: 1);
					l(k - 1, A.x + d[k - 1], 0);
					l(k, A.x + d[k], 0);
					l(k + 1, A.x + d[k + 1], 0)
				}
			}
		},
		end : function(H) {
			if (e.disableTouch) {
				return
			}
			if (typeof B == "undefined") {
				return
			}
			var J = +new Date - h.time;
			var G = Number(J) < 250 && Math.abs(A.x) > 20
					|| Math.abs(A.x) > r / 2;
			var F = !k && A.x > 0 || k == s.length - 1 && A.x < 0;
			if (e.continuous) {
				F = false
			}
			var I = A.x < 0;
			if (!B) {
				if (G && !F) {
					if (I) {
						if (e.continuous) {
							q(i(k - 1), -r, 0);
							q(i(k + 2), r, 0)
						} else {
							q(k - 1, -r, 0)
						}
						q(k, d[k] - r, w);
						q(i(k + 1), d[i(k + 1)] - r, w);
						k = i(k + 1)
					} else {
						if (e.continuous) {
							q(i(k + 1), r, 0);
							q(i(k - 2), -r, 0)
						} else {
							q(k + 1, r, 0)
						}
						q(k, d[k] + r, w);
						q(i(k - 1), d[i(k - 1)] + r, w);
						k = i(k - 1)
					}
					var E = k;
					if (v && (k > 1)) {
						E = k - 2
					}
					e.callback && e.callback(E, s[k])
				} else {
					if (e.continuous) {
						q(i(k - 1), -r, w);
						q(k, 0, w);
						q(i(k + 1), r, w)
					} else {
						q(k - 1, -r, w);
						q(k, 0, w);
						q(k + 1, r, w)
					}
				}
			}
			c.removeEventListener("touchmove", b, false);
			c.removeEventListener("touchend", b, false)
		},
		transitionEnd : function(F) {
			if (parseInt(F.target.getAttribute("data-index"), 10) == k) {
				if (C) {
					z()
				}
				var E = k;
				if (v && (k > 1)) {
					E = k - 2
				}
				e.transitionEnd && e.transitionEnd.call(F, E, s[k])
			}
		}
	};
	n();
	if (C) {
		z()
	}
	if (D.addEventListener) {
		if (D.touch) {
			c.addEventListener("touchstart", b, false)
		}
		if (D.transitions) {
			c.addEventListener("webkitTransitionEnd", b, false);
			c.addEventListener("msTransitionEnd", b, false);
			c.addEventListener("oTransitionEnd", b, false);
			c.addEventListener("otransitionend", b, false);
			c.addEventListener("transitionend", b, false)
		}
		window.addEventListener("resize", b, false)
	} else {
		window.onresize = function() {
			n()
		}
	}
	return {
		setup : function() {
			n()
		},
		slide : function(F, E) {
			t();
			a(F, E)
		},
		prev : function() {
			t();
			o()
		},
		next : function() {
			t();
			p()
		},
		getPos : function() {
			return k
		},
		getNumSlides : function() {
			return g
		},
		kill : function() {
			t();
			c.style.width = "auto";
			c.style.left = 0;
			var F = s.length;
			while (F--) {
				var E = s[F];
				E.style.width = "100%";
				E.style.left = 0;
				if (D.transitions) {
					l(F, 0, 0)
				}
			}
			if (D.addEventListener) {
				c.removeEventListener("touchstart", b, false);
				c.removeEventListener("webkitTransitionEnd", b, false);
				c.removeEventListener("msTransitionEnd", b, false);
				c.removeEventListener("oTransitionEnd", b, false);
				c.removeEventListener("otransitionend", b, false);
				c.removeEventListener("transitionend", b, false);
				window.removeEventListener("resize", b, false)
			} else {
				window.onresize = null
			}
		}
	}
}
if (window.jQuery || window.Zepto) {
	(function(a) {
		a.fn.Swipe = function(b) {
			return this.each(function() {
				a(this).data("Swipe", new Swipe(a(this)[0], b))
			})
		}
	})(window.jQuery || window.Zepto)
};