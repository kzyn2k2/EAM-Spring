package com.eam.app.service;

import com.eam.app.dto.Pager;
import com.eam.app.dto.department.DepartmentDTO;
import com.eam.app.dto.department.DepartmentInfo;
import com.eam.app.dto.department.DepartmentRegisterForm;
import com.eam.app.dto.department.DepartmentUpdateForm;

public interface DepartmentService {

	DepartmentDTO registerDepartment(DepartmentRegisterForm form);
	
	DepartmentDTO updateDepartment(DepartmentUpdateForm form);
	
	void removeDepartment(int id);
	
	Pager<DepartmentInfo> getDepartments(int pageNum, int pageSize);
	
	
}
