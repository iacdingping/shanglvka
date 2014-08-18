package com.slk.core.service.sys;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springside.modules.security.utils.Digests;
import org.springside.modules.utils.Collections3;
import org.springside.modules.utils.Encodes;

import com.slk.core.entity.sys.Role;
import com.slk.core.entity.sys.RoleModule;
import com.slk.core.entity.sys.User;
import com.slk.core.entity.sys.UserRole;
import com.slk.core.manager.sys.RoleManager;
import com.slk.core.manager.sys.RoleModuleManager;
import com.slk.core.manager.sys.UserManager;
import com.slk.core.manager.sys.UserRoleManager;

@Component
public class UserService {
	public static final String HASH_ALGORITHM = "SHA-1";
	public static final int HASH_INTERATIONS = 1024;
	private static final int SALT_SIZE = 8;
	private static Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired private UserManager userManager;
	@Autowired private RoleManager roleManager;
	@Autowired private UserRoleManager userRoleManager;
	@Autowired private RoleModuleManager roleModuleManager;
	
	public User findUserByLoginName(String username) {
		return userManager.getByLoginName(username);
	}

	public void createUser(User user) {
		if (StringUtils.isNotBlank(user.getPassword())) {
			entryptPassword(user);
		}
		userManager.save(user);
	}
	
	public List<Role> getRoleByUser(Long userId) {
		List<UserRole> userRoles = userRoleManager.getByUser(userId);
		List<Role> result = new ArrayList<Role>();
		for(UserRole userRole : userRoles) {
			result.add(roleManager.getById(userRole.getRole()));
		}
		return result;
	}

	public Collection<String> getRolePemissions(Role role) {
		List<RoleModule> roleModules = roleModuleManager.listByRole(role.getId());
		return Collections3.extractToList(roleModules, "permission");
	}
	
	/**
	 * 设定安全的密码，生成随机的salt并经过1024次 sha-1 hash
	 */
	private void entryptPassword(User user) {
		byte[] salt = Digests.generateSalt(SALT_SIZE);
		user.setSalt(Encodes.encodeHex(salt));

		byte[] hashPassword = Digests.sha1(user.getPassword().getBytes(), salt, HASH_INTERATIONS);
		user.setPassword(Encodes.encodeHex(hashPassword));
	}
	
}
