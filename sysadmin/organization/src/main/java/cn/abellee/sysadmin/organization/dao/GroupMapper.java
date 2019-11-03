package cn.abellee.sysadmin.organization.dao;

import cn.abellee.sysadmin.organization.entity.po.Group;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface GroupMapper extends BaseMapper<Group> {
}