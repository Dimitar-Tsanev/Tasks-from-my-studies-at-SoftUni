function solve() {
   document.querySelector('#btnSend').addEventListener('click', onClick);
   //   TODO:
   class Restaurant{
      constructor(name, employees){
         this.name = name;
         this.employees = this.#setEmployees(employees);
         this.averageSalary = this.#setAverageSalary();
         this.employeeWithBestSalary = this.employees[0];
      }
      addEmployees(employees){
         employees.split(', ').forEach(employeeData => {
            const [employeeName, salary] = employeeData.split(/\s+/);
            this.employees.push({employeeName, salary});
         });

         this.employees.sort((empl1,empl2) => Number(empl2.salary) - Number(empl1.salary));
         this.averageSalary = this.#setAverageSalary();
         this.employeeWithBestSalary = this.employees[0];
      }
      #setEmployees(employees){
         return employees.split(', ').map(employeeData => {
            const [employeeName, salary] = employeeData.split(/\s+/);
            return {employeeName, salary};
            
         }).sort((empl1,empl2) => Number(empl2.salary) - Number(empl1.salary));
      }
      #setAverageSalary(){
         return ((this.employees.reduce((acc, cur) => {
            return acc += Number(cur.salary);
            
         }, 0)) / this.employees.length).toFixed(2);
      }
   }
   
   function onClick () {
      const inputElement = document.querySelector('#inputs textarea');
      const outputRestaurantElement = document.querySelector('#outputs #bestRestaurant p'); 
      const outputEmployeesElement = document.querySelector('#outputs #workers p'); 
      
      const data = JSON.parse(inputElement.value);
      inputElement.value = '';
      
      let restaurants = [];

      data.forEach(restaurant => {
         const [name, employees] = restaurant.split(' - ');
         const hasRestaurant = restaurants.filter(r => r.name === name)[0];
         
         if (hasRestaurant){
            const index = restaurants.indexOf(hasRestaurant);
            restaurants[index].addEmployees(employees);

         }else{
            restaurants.push( new Restaurant(name, employees));
         }
      });
      restaurants.sort((restaurant1, restaurant2) => restaurant2.averageSalary - restaurant1.averageSalary);

      outputRestaurantElement.textContent = `Name: ${restaurants[0].name} Average Salary: ${restaurants[0].averageSalary} Best Salary: ${Number(restaurants[0].employeeWithBestSalary.salary).toFixed(2)}`;
      outputEmployeesElement.textContent = restaurants[0].employees.reduce((acc, cur) => {
         return acc.concat(`Name: ${cur.employeeName} With Salary: ${(cur.salary)} ` )
      },'')
   }
}
