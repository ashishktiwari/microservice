package com.at.EmployeeSearch.service;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.at.EmployeeSearch.domain.model.Employee;

@Service

public class EmployeeSearchService {

	private static Map<Long, Employee> EmployeeRepsitory = null;
	static {
		Stream<String> employeeStream = Stream.of("1,Aparna Tiwari,QA,Analyst", "2,Amisha Tiwari,BA,Business Analyst",
				"3,Ashish  Tiwari,Cloud,Sr.Architect");
		EmployeeRepsitory = employeeStream.map(employeeStr -> {
			String[] info = employeeStr.split(",");
			return createEmployee(new Long(info[0]), info[1], info[2], info[3]);
		}).collect(Collectors.toMap(Employee::getEmployeeId, emp -> emp));
	}

	private static Employee createEmployee(Long id, String name, String practiceArea, String designation) {
		Employee emp = new Employee();
		emp.setEmployeeId(id);
		emp.setName(name);
		emp.setPracticeArea(practiceArea);
		emp.setDesignation(designation);
		emp.setCompanyInfo("AKT");
		return emp;
	}

	public Employee findById(Long id) {
		return EmployeeRepsitory.get(id);
	}

	public Collection<Employee> findAll() {
		return EmployeeRepsitory.values();
	}
}
