package cn.abellee.sysadmin.organization.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cn.abellee.sysadmin.organization.entity.po.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface RoleMapper extends BaseMapper<Role> {
}