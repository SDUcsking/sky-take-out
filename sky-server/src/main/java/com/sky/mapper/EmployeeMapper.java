package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.entity.Employee;
import com.sky.enumeration.OperationType;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface EmployeeMapper {

    @Select("select * from employee where id=#{id}")
     Employee getById(Long id) ;

    Page<Employee> pageQuery(EmployeePageQueryDTO employeePageQueryDTO);

    /**
     * 根据用户名查询员工
     * @param username
     * @return
     */
    @Select("select * from employee where username = #{username}")
    Employee getByUsername(String username);
    @AutoFill(value= OperationType.INSERT)
    @Insert("insert into employee(name,username,password,phone,sex,id_number,status,create_time,update_user,update_time,create_user)" +
            "values" +
            "(#{name},#{username},#{password},#{phone},#{sex},#{idNumber},#{status},#{createTime},#{updateUser},#{updateTime},#{createUser})")
    void insert(Employee employee);
    @AutoFill(value= OperationType.UPDATE)
    void update(Employee employee);
}
