//TODO
const baseURl = 'http://localhost:3030/jsonstore/tasks';

const requester = {
    async get(){
        try {
            const response = await fetch(baseURl);
            return await response.json();
            
        } catch (error) {
            return error;
        }
    },
    async post(object){
        try {
            return fetch(baseURl, {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify(object)
            });
        } catch (error) {
            return console.log(error + 'error');
        }
    },
    async put(id, object){
        try {
            return fetch(`${baseURl}/${id}`, {
                method: "PUT",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify(object)
            });
        } catch (error) {
            return console.log(error + 'error');
        }
    },
    async delete(id){
        return fetch(`${baseURl}/${id}`,{
            method: 'DELETE'
            
        })
        .catch(error => console.log(error + 'error'));
    }
}
const click = 'click';
const disabled = 'disabled';

const mealContainer = document.getElementById('list');
const mealElements = mealContainer.querySelector('.meal').cloneNode(true);

mealContainer.innerHTML = '';

const inputFoodName = document.getElementById('food')
const inputTime = document.getElementById('time')
const inputCalories = document.getElementById('calories')
clearInput();

const loadButton = document.getElementById('load-meals');
loadButton.addEventListener(click, loadMeals)

const addButton = document.getElementById('add-meal');
addButton.addEventListener(click, addMeal);

const editButton = document.getElementById('edit-meal');


async function loadMeals(){
    let result = await requester.get();
    mealContainer.innerHTML = '';

    for (const key in result) {
        const {_id, calories, food, time} = result[key];
        
        const newMeal = mealElements.cloneNode(true);
        newMeal.setAttribute('id', _id);
        
        newMeal.querySelector('h2').textContent = food;
        newMeal.querySelector('h3:nth-of-type(1)').textContent = time;
        newMeal.querySelector('h3:nth-of-type(2)').textContent = calories;
        
        const changeButton = newMeal.querySelector('#meal-buttons .change-meal');
        changeButton.addEventListener(click, () => {
            addButton.setAttribute(disabled, disabled);
            editButton.removeAttribute(disabled);

            inputFoodName.value = newMeal.querySelector('h2').textContent;
            inputTime.value =  newMeal.querySelector('h3:nth-of-type(1)').textContent;
            inputCalories.value = newMeal.querySelector('h3:nth-of-type(2)').textContent;

            editButton.addEventListener(click,() => editMeal(_id));
        })
        
        const deleteButton = newMeal.querySelector('#meal-buttons .delete-meal');
        deleteButton.addEventListener(click, () => deleteMeal(_id))
        
        mealContainer.appendChild(newMeal);
        
    }
    
}
async function editMeal(id) {
    const calories = inputCalories.value; 
    const food = inputFoodName.value;
    const time = inputTime.value;

    await requester.put(id, {calories, food, time});

    editButton.setAttribute(disabled, disabled);
    addButton.removeAttribute(disabled);

    clearInput();

    loadMeals();
}

async function addMeal(){
    
    const calories = inputCalories.value; 
    const food = inputFoodName.value;
    const time = inputTime.value;
    
    await requester.post({calories, food, time});
    
    clearInput()
    
    loadMeals();
}

function clearInput(){
    inputFoodName.value = ''
    inputTime.value = ''
    inputCalories.value = ''
}

async function deleteMeal(id){
    await requester.delete(id);

    loadGames();
}