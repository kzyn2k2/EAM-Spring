package com.eam.app.service.util;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eam.app.dto.Pager;
import com.eam.app.dto.department.DepartmentDTO;
import com.eam.app.dto.department.DepartmentInfo;
import com.eam.app.dto.department.DepartmentRegisterForm;
import com.eam.app.dto.department.DepartmentUpdateForm;
import com.eam.app.model.Department;
import com.eam.app.repository.DepartmentRepository;
import com.eam.app.service.DepartmentService;
import com.eam.app.util.DepartmentUtil;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	private DepartmentRepository departmentRepository;
	private DepartmentUtil departmentUtil;

	@Override
	public DepartmentDTO registerDepartment(DepartmentRegisterForm form) {
		Department department = departmentUtil.mapEntity(form);
		department = departmentRepository.save(department);
		return departmentUtil.mapDTO(department);
	}

	@Transactional
	@Override
	public DepartmentDTO updateDepartment(DepartmentUpdateForm form) {
		Optional<Department> result = departmentRepository.findById(form.id());
		if(result.isPresent()) {
			Department department = result.get();
			department.setName(form.name());
			department = departmentRepository.save(department);
			return departmentUtil.mapDTO(department);
		}
		return null;
	}

	@Transactional
	@Override
	public void removeDepartment(int id) {
		departmentRepository.removeDepartment(id);
	}

	@Override
	public Pager<DepartmentInfo> getDepartments(int pageNum, int pageSize) {
		Pageable pageable = PageRequest.of(pageNum, pageSize);
		Page<Department> page = departmentRepository.getDepartments(pageable);
		return departmentUtil.mapToDepartmentInfo(page);
	}

	
}
