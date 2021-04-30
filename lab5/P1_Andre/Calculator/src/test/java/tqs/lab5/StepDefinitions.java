package tqs.lab5;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;
import static java.util.Arrays.asList;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class StepDefinitions {
    Calculator c;

    @Given("opaaaa que ela ligou-se")
    public void a_calculator_i_just_turned_on() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("* musica de entrada * Ta na nã nâ");
        c = new Calculator();
    }

    @When("I add {int} and {int}")
    public void i_add_and(Integer int1, Integer int2) {
        c.push(int1);
        c.push(int2);
        c.push("+");
    }

    @When("I substract {int} to {int}")
    public void i_substract_to(Integer int1, Integer int2) {
        c.push(int1);
        c.push(int2);
        c.push("-");
    }

    @When("I multiply {int} by {int}")
    public void i_multiply_by(Integer int1, Integer int2) {
        c.push(int1);
        c.push(int2);
        c.push("*");
    }

    @When("I divide {int} by {int}")
    public void i_divide_by(Integer int1, Integer int2) {
        c.push(int1);
        c.push(int2);
        c.push("/");
    }

    @Then("the result is (\\d+)$")
    public void the_result_is(double expected) {
        assertEquals(expected, c.value());
    }
}

class Calculator {
    private final Deque<Number> stack = new LinkedList<Number>();
    private static final List<String> OPS = asList("-", "+", "*", "/");

    public void push(Object arg) {
        if (OPS.contains(arg)) {
            Number y = stack.removeLast();
            Number x = stack.isEmpty() ? 0 : stack.removeLast();
            Double val = null;
            if (arg.equals("-")) {
                val = x.doubleValue() - y.doubleValue();
            } else if (arg.equals("+")) {
                val = x.doubleValue() + y.doubleValue();
            } else if (arg.equals("*")) {
                val = x.doubleValue() * y.doubleValue();
            } else if (arg.equals("/")) {
                val = x.doubleValue() / y.doubleValue();
            }
            push(val);
        } else {
            stack.add((Number) arg);
        }
    }

    public Number value() {
        return stack.getLast();
    }
}
