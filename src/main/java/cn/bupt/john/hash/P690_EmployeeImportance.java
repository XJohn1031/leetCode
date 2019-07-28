package cn.bupt.john.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 递归or DFS
 */
public class P690_EmployeeImportance {

    public static void main(String[] args) {
        P690_EmployeeImportance solution = new P690_EmployeeImportance();
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1, 5, new ArrayList<Integer>(){
            {
                add(2);
                add(3);
            }
        }));
        list.add(new Employee(2, 3, new ArrayList<>()));
        list.add(new Employee(3, 3, new ArrayList<>()));
        System.out.println(solution.getImportance(list, 1));
    }

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        return getSub(map, id);
    }

    public int getSub(Map<Integer, Employee> map, int id) {
        Employee employee = map.get(id);
        int result = employee.importance;
        for (Integer subordinate : employee.subordinates) {
            result += getSub(map, subordinate);
        }
        return result;
    }

    static class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;

        public Employee(int id, int importance, List<Integer> subordinates) {
            this.id = id;
            this.importance = importance;
            this.subordinates = subordinates;
        }
    };
}
