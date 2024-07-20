function createEmployeesList(employeesList){
    class Employee{
        constructor (employeeName){
            this.employeeName = employeeName;
            this.employeeNumber = this.#setEmployeePersonalNumber(this.employeeName);
        }
        
        #setEmployeePersonalNumber(employeeName){
            return employeeName.length
        }
    }
    let employees = []
    
    for (const employeeName of employeesList) {
        const employee = new Employee(employeeName)
        employees.push(employee);
    }

    for (const employee of employees) {
        console.log (`Name: ${employee.employeeName} -- Personal Number: ${employee.employeeNumber}`)
    }
}
createEmployeesList(['Silas Butler',
                    'Adnaan Buckley', 
                    'Juan Peterson', 
                    'Brendan Villarreal' ] );

createEmployeesList(['Samuel Jackson',
                    'Will Smith',
                    'Bruce Willis',
                    'Tom Holland' ]);