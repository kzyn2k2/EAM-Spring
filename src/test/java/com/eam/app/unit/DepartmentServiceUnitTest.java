package com.eam.app.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.eam.app.dto.department.DepartmentDTO;
import com.eam.app.dto.department.DepartmentRegisterForm;
import com.eam.app.model.Department;
import com.eam.app.repository.DepartmentRepository;
import com.eam.app.service.util.DepartmentServiceImpl;
import com.eam.app.util.DepartmentUtil;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceUnitTest {

	@Mock
	private DepartmentRepository departmentRepository;
	
	@Mock
	private DepartmentUtil departmentUtil;
	
	@InjectMocks
	private DepartmentServiceImpl departmentService;
	
	private Department mappedDepartment;
	private Department returnedDepartment;
	private DepartmentRegisterForm form;
	
	@BeforeEach
	public void setup() {
		mappedDepartment = Department.builder().name("Finance").build();
		returnedDepartment = Department.builder().id(1)
					 .name("Finance")
					 .active(true)
					 .createdOn(LocalDateTime.now())
					 .updatedOn(LocalDateTime.now())
					 .build();
		
		form = new DepartmentRegisterForm("Finance");
	}
	
	@DisplayName("Test for registering department")
	@Test
	public void saveEmployeeTest() {
		when(departmentUtil.mapEntity(form)).thenReturn(mappedDepartment);
		when(departmentUtil.mapDTO(returnedDepartment)).thenReturn(new DepartmentDTO(1, "Finance"));
		when(departmentRepository.save(mappedDepartment)).thenReturn(returnedDepartment);
		
		DepartmentDTO dto = departmentService.registerDepartment(form);
		assertNotNull(dto);
		assertEquals(1, dto.id());
		assertEquals("Finance", dto.name());
	}
}
