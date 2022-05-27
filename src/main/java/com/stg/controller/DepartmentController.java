package com.stg.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stg.entity.Department;
import com.stg.repository.DepartmentRepository;

@RestController
@RequestMapping (value = "/dept")
public class DepartmentController {
		@Autowired
		private DepartmentRepository departmentRepository;
		
		@PostMapping(value = "/addDepartment", consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
		public Department addDepartment(@RequestBody Department department) {
			return	departmentRepository.save(department);

		}
		
		@GetMapping(value = "/getDepartment/{deptId}", consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
		public Department getDepartment(@PathVariable("deptId") int deptId) {
			return	departmentRepository.getById(deptId);

		}
}
