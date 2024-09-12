package com.eam.app.util.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.eam.app.dto.Pager;
import com.eam.app.dto.department.DepartmentDTO;
import com.eam.app.dto.department.DepartmentInfo;
import com.eam.app.dto.department.DepartmentRegisterForm;
import com.eam.app.model.Department;
import com.eam.app.util.DepartmentUtil;

@Component
public class DepartmentUtilImpl implements DepartmentUtil {

	@Override
	public Department mapEntity(DepartmentRegisterForm form) {
		Department department = new Department();
		department.setName(form.name());
		return department;
	}

	@Override
	public Pager<DepartmentInfo> mapToDepartmentInfo(Page<Department> page) {
		List<DepartmentInfo> departmentInfo = page.getContent().stream()
											 .map(d -> new DepartmentInfo(d.getId(), d.getName(), d.getEmployees().size())).toList();
		return new Pager<DepartmentInfo>(departmentInfo, page.getTotalElements(), page.getTotalPages());
	}

	@Override
	public DepartmentDTO mapDTO(Department department) {
		return new DepartmentDTO(department.getId(), department.getName());
	}

}
