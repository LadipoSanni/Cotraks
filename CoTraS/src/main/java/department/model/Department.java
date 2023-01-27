package department.model;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;

public class Department {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String deptName;
        private String subDeptNumber;
        private String location;
        @Enumerated(value = EnumType.STRING)
        private DepartmentType departmentType;
//        @Enumerated(value = EnumType.STRING)
//        private RoomStatus roomStatus;

}
