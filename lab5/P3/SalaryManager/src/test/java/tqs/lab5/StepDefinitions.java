package tqs.lab5;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class StepDefinitions {
    SalaryManager manager;

    @Given("^the salary management system is initialized with the following data$")
    public void the_salary_management_system_is_initialized_with_the_following_data(DataTable table) throws Throwable {
        List<List<String>> rows = table.asLists(String.class);
        List<Employee> employees = new ArrayList<>();

        for (List<String> columns : rows) {
            if(columns.get(0).equals("id"))
                continue;

            employees.add(new Employee(Integer.valueOf(columns.get(0)), columns.get(1),Float.valueOf(columns.get(2))));
        }
        manager = new SalaryManager(employees);
    }

    @When("^the boss increases the salary for the employee with id '(\\d+)' by (\\d+)%$")
    public void the_boss_increases_the_salary_for_the_employee_with_id_by(final int id, final int increaseInPercent) throws Throwable {
        manager.increaseSalary(id, increaseInPercent);
    }

    @Then("^the payroll for the employee with id '(\\d+)' should display a salary of (\\d+)$")
    public void the_payroll_for_the_employee_with_id_should_display_a_salary_of(final int id, final float salary) throws Throwable {
        Employee nominee = manager.getPayroll(id);
        assertThat(nominee.getSalary(), equalTo(salary));
    }
}

class Employee {
    private int id;
    private String user;
    private float salary;


    public Employee(int id, String user, float salary){
        this.id=id;
        this.user=user;
        this.salary=salary;
    }

    public int getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public float getSalary() {
        return salary;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
}

class SalaryManager {
    private Map<Integer, Employee> employees = new HashMap<>();

    public SalaryManager(final List<Employee> employees) {
        this.employees = employees.stream().collect(Collectors.toMap(Employee::getId, Function.<Employee> identity()));

    }

    public void increaseSalary(final Integer id, final int increaseInPercent) {
        Employee nominee = employees.get(id);
        float oldSalary = nominee.getSalary();
        nominee.setSalary(oldSalary + oldSalary * increaseInPercent / 100);
    }

    public Employee getPayroll(final int id) {
        return employees.get(id);
    }
}