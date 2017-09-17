package com.zccpro.back.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zccpro.back.service.TypeService;
import com.zccpro.dao.TypeMapper;
import com.zccpro.domain.Type;
@Service("typeService")
public class TypeServiceImpl implements TypeService {

	@Resource
	private TypeMapper typeMapper;
	public List<Type> selectTypeList() {
		return typeMapper.selectTypeList();
	}

}
