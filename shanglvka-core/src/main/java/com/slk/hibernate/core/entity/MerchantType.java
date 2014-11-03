/*****************************************************************
 *仿佛兮若轻云之蔽月，飘飘兮若流风之回雪
 *@author 禹波
 *@copyright all rights reserved (c) wyyft@163.com
 *****************************************************************/
package com.slk.hibernate.core.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.Where;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Store;
import org.hibernate.validator.constraints.Length;

import com.google.common.collect.Lists;
import com.thinkgem.jeesite.common.persistence.BaseEntity;
import com.thinkgem.jeesite.modules.sys.entity.Menu;
import com.thinkgem.jeesite.modules.sys.entity.User;

/**
 * 商旅类别Entity
 * 
 * @author 禹波
 * @version 2014-11-01
 */
@Entity
@Table(name = "slk_merchant_type")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class MerchantType extends BaseEntity<MerchantType> {

	private static final long serialVersionUID = 1L;

	private java.lang.Long id; // id
	private java.lang.String name; // name
	private MerchantType parent;
	private String delFlag;
	private List<MerchantType> childList = Lists.newArrayList(); // 拥有子区域列表

	@OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
	@Where(clause = "del_flag='" + DEL_FLAG_NORMAL + "'")
	@OrderBy(value = "id")
	@Fetch(FetchMode.SUBSELECT)
	@NotFound(action = NotFoundAction.IGNORE)
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	public List<MerchantType> getChildList() {
		return childList;
	}

	public void setChildList(List<MerchantType> childList) {
		this.childList = childList;
	}

	@Length(min = 1, max = 1)
	@Field(index = Index.YES, analyze = Analyze.NO, store = Store.YES)
	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public MerchantType() {
		this.delFlag = DEL_FLAG_NORMAL;
	}

	public MerchantType(java.lang.Long id) {
		this();
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_id")
	@NotFound(action = NotFoundAction.IGNORE)
	@NotNull
	public MerchantType getParent() {
		return parent;
	}

	public void setParent(MerchantType parent) {
		this.parent = parent;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public java.lang.Long getId() {
		return id;
	}

	public void setId(java.lang.Long id) {
		this.id = id;
	}

	public java.lang.String getName() {
		return name;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}

	private List<MerchantMap> mapList = Lists.newArrayList(); // 拥有用户列表

	@ManyToMany(mappedBy = "typeList", fetch = FetchType.LAZY)
	@Where(clause = "del_flag='" + DEL_FLAG_NORMAL + "'")
	@OrderBy("id")
	@Fetch(FetchMode.SUBSELECT)
	@NotFound(action = NotFoundAction.IGNORE)
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	public List<MerchantMap> getMapList() {
		return mapList;
	}

	public void setMapList(List<MerchantMap> mapList) {
		this.mapList = mapList;
	}

	@Transient
	public static void sortList(List<MerchantType> list,
			List<MerchantType> sourcelist, Long parentId) {
		for (int i = 0; i < sourcelist.size(); i++) {
			MerchantType e = sourcelist.get(i);
			if (e.getParent() != null && e.getParent().getId() != null
					&& e.getParent().getId().equals(parentId)) {
				list.add(e);
				// 判断是否还有子节点, 有则继续获取子节点
				for (int j = 0; j < sourcelist.size(); j++) {
					MerchantType childe = sourcelist.get(j);
					if (childe.getParent() != null
							&& childe.getParent().getId() != null
							&& childe.getParent().getId().equals(e.getId())) {
						sortList(list, sourcelist, e.getId());
						break;
					}
				}
			}
		}
	}

	@Transient
	public static boolean isAdmin(Long id) {
		return id != null && id == 1;
	}
}
