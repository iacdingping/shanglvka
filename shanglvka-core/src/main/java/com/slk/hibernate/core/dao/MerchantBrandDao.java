/*****************************************************************
 *仿佛兮若轻云之蔽月，飘飘兮若流风之回雪
 *@author 禹波
 *@copyright all rights reserved (c) wyyft@163.com
 *****************************************************************/
package com.slk.hibernate.core.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.slk.hibernate.core.entity.MerchantBrand;
import com.thinkgem.jeesite.common.persistence.BaseDao;
import com.thinkgem.jeesite.common.persistence.Parameter;
import com.thinkgem.jeesite.common.utils.StringUtils;

/**
 * 商旅品牌DAO接口
 * 
 * @author 禹波
 * @version 2014-11-01
 */
@Repository
public class MerchantBrandDao extends BaseDao<MerchantBrand> {
	/**
	 * 通过类别和区域查找品牌
	 * 
	 * @param typeId
	 * @param areaId
	 * @return
	 */
	public List<MerchantBrand> findAllByTypeAndArea(Long typeId, String areaId,
			String name) {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from slk_merchant_brand  where id in (select distinct smm.brand_id from slk_merchant_map smm ");
		sb.append(" where 1=1 ");
		if (typeId != null) {
			sb.append(" and smm.id in (select distinct mt.map_id from slk_map_type mt where mt.type_id in (select smt.id from slk_merchant_type smt where smt.parent_id ="
					+ typeId + " or smt.id=" + typeId + "))");
		}
		if (StringUtils.isNotEmpty(areaId)) {
			sb.append(" and smm.area_id in (select sa.id from sys_area sa where sa.parent_ids like '%"
					+ areaId + ",%' or sa.id='" + areaId + "') ");
		}
		sb.append(")");
		if (StringUtils.isNotEmpty(name)) {
			sb.append(" and name like '%");
			sb.append(name);
			sb.append("%'");
		}
		System.out.println(sb.toString());
		return findBySql(sb.toString(), null, MerchantBrand.class);
	}
}