package employees.services.impl;

import employees.entities.DTOs.EmployeeDTO;
import employees.entities.DTOs.ManagerDTO;
import employees.entities.DTOs.SimpleEmployeeDTO;
import employees.entities.EmployeeTaskOne;
import employees.entities.EmployeeTaskTwo;
import employees.repositories.EmployeeRepository;
import employees.repositories.EmployeeTaskTwoRepository;
import employees.services.EmployeeService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeTaskTwoRepository employeeTaskTwoRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public EmployeeServiceImpl ( EmployeeRepository employeeRepository, ModelMapper modelMapper, EmployeeTaskTwoRepository employeeTaskTwoRepository ) {
        this.employeeRepository = employeeRepository;
        this.employeeTaskTwoRepository = employeeTaskTwoRepository;
        this.modelMapper = modelMapper;
    }

    //1.Simple Mapping
    @Override
    public Set<SimpleEmployeeDTO> getAllEmployees () {
        return employeeRepository.findAll ( ).stream ( ).map ( employee -> modelMapper.map ( employee, SimpleEmployeeDTO.class ) ).collect ( Collectors.toSet ( ) );
    }

    @Transactional
    @Override
    public int getEmployeesCount () {
        return (int) employeeRepository.count ( );
    }

    @Override
    public int getEmployeesCountTasTwo () {
        return (int) employeeTaskTwoRepository.count ( );
    }

    //2.Advanced Mapping
    @Transactional
    @Override
    public Set<ManagerDTO> getAllManagers () {
        return employeeTaskTwoRepository.findAllManager ()
                .stream( )
                .map ( m-> modelMapper.map ( m, ManagerDTO.class ) )
                .collect ( Collectors.toSet ( ) );
    }

    //3.Projection
    @Override
    public Set<EmployeeDTO> getEmployeesBornBefore ( String date ) {
        LocalDate bornBefore = LocalDate.parse (date, DateTimeFormatter.ofPattern ("dd-MM-yyyy" ) );

        return employeeTaskTwoRepository.findAllByBirthDateBefore ( bornBefore ).stream( ).map ( e->modelMapper.map ( e, EmployeeDTO.class ) ).collect( Collectors.toSet());
    }

    @Override
    public void seedEmployeesTaskTwo () {
        List<EmployeeTaskTwo> employeesTaskTwo = List.of (
                new EmployeeTaskTwo ( "Jania", "De La Salle", BigDecimal.valueOf ( 8665.84 ) ),
                new EmployeeTaskTwo ( "Allard", "Pickle", BigDecimal.valueOf ( 1214.74 ) ),
                new EmployeeTaskTwo ( "Ally", "Pigged", BigDecimal.valueOf ( 7852.02 ) ),
                new EmployeeTaskTwo ( "Allan", "Rigger", BigDecimal.valueOf ( 7852.02 ) ),
                new EmployeeTaskTwo ( "John", "Doe", BigDecimal.valueOf ( 7852.02 ) ),
                new EmployeeTaskTwo ( "Sam", "Roger", BigDecimal.valueOf ( 7852.02 ) )
        );

        List<String> addresses = List.of (
                "1522 Northland Hill",
                "837 Logan Plaza",
                "108 Logan Alley",
                "1544 Wasteland Hill",
                "937 Lillian Plaza",
                "10886 Lillian Alley"
        );

        List<LocalDate> birthdays = List.of (
                LocalDate.of ( 2001, 3, 7 ),
                LocalDate.of ( 1989, 12, 15 ),
                LocalDate.of ( 1987, 10, 19 ),
                LocalDate.of ( 1992, 7, 4 ),
                LocalDate.of ( 1991, 6, 19 ),
                LocalDate.of ( 1984, 3, 7 )
        );

        for ( int i = 0 ; i < employeesTaskTwo.size ( ) ; i++ ) {
            EmployeeTaskTwo employee = employeesTaskTwo.get ( i );
            employee.setAddress ( addresses.get ( i ) );
            employee.setBirthDate ( birthdays.get ( i ) );

            if ( i % 3 == 0 ) {
                employee.setManager ( employeesTaskTwo.get ( 0 ) );

            } else if ( i % 2 == 0 ) {
                employee.setManager ( employeesTaskTwo.get ( 1 ) );

            }

            employeeTaskTwoRepository.save ( employee );
        }

    }

    @Override
    public void seedEmployeesTaskOne () {
        EmployeeTaskOne employee1 = new EmployeeTaskOne ( "Jania", "De La Salle", BigDecimal.valueOf ( 8665.84 ) );
        EmployeeTaskOne employee2 = new EmployeeTaskOne ( "Allard", "Pickle", BigDecimal.valueOf ( 1214.74 ) );
        EmployeeTaskOne employee3 = new EmployeeTaskOne ( "Oby", "Triggel", BigDecimal.valueOf ( 7852.02 ) );

        employee1.setAddress ( "1522 Northland Hill" );
        employee2.setAddress ( "837 Logan Plaza" );
        employee3.setAddress ( "10886 Lillian Alley" );

        employee1.setBirthDate ( LocalDate.of ( 1992, 6, 4 ) );
        employee2.setBirthDate ( LocalDate.of ( 1987, 10, 19 ) );
        employee3.setBirthDate ( LocalDate.of ( 2001, 3, 7 ) );

        employeeRepository.save ( employee1 );
        employeeRepository.save ( employee2 );
        employeeRepository.save ( employee3 );
    }
}
