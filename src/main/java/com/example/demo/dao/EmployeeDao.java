package com.example.demo.dao;

import com.example.demo.pojo.Department;
import com.example.demo.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@Repository
public class EmployeeDao {
    private  static Map<Integer, Employee> employees = null;
    //员工有所属的部门
    @Autowired
    private DepartmentDao departmentDao;
    static {
        employees = new HashMap<Integer, Employee>(); ///创建依个部门表
        employees.put(1001,new Employee(1001,"AA","A7696139@qq.com",1,new Department(101,"教学部")));
        employees.put(1002,new Employee(1002,"BB","B7696139@qq.com",0,new Department(101,"市场部")));
        employees.put(1003,new Employee(1003,"CC","C7696139@qq.com",1,new Department(101,"教研部")));
        employees.put(1004,new Employee(1004,"DD","D7696139@qq.com",0,new Department(101,"后勤部")));
        employees.put(1005,new Employee(1005,"EE","E7696139@qq.com",1,new Department(101,"运营部")));
    }
    //增加一个员工
    //主键自增
    private static Integer initId = 1006;
    public void save(Employee employee){
        if(employee.getId()==null){
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(),employee);
    }
    //查询全部员工
    public Collection<Employee> getAll(){
        return employees.values();
    }
    //通过id查询员工
    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }
    //删除通过id员工
    public void delete(Integer id){
         employees.remove(id);
    }
}
