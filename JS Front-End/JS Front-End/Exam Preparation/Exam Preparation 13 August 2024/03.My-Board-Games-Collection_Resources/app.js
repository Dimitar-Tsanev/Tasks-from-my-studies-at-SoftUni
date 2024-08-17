//TODO...
const baseURl = 'http://localhost:3030/jsonstore/games'

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

const loadButton = document.getElementById('load-games');

const gamesContainer = document.getElementById('games-list');
const gameElement = gamesContainer.querySelector('div.board-game').cloneNode(true);

gamesContainer.innerHTML = '';

const gameNameInputElement = document.getElementById('g-name');
const gameTypeInputElement = document.getElementById('type');
const gameMaxPlayersInputElement = document.getElementById('players');

const editButton = document.getElementById('edit-game');
const addButton = document.getElementById('add-game');

loadButton.addEventListener('click', loadGames);
addButton.addEventListener('click', addGame);

async function loadGames(){
    gamesContainer.innerHTML = '';
    let response = requester.get();
    
    response.then(result => {
        for (const key in result) {
            const {_id, name, players, type} = result[key];
            
            const clonedGame = gameElement.cloneNode(true);
            
            const descriptionElements = clonedGame.querySelectorAll('div.content p')
            
            descriptionElements[0].textContent = name;
            descriptionElements[1].textContent  = type;
            descriptionElements[2].textContent  = players;
            console.log(_id)
            clonedGame.setAttribute('id', _id);
            
            const changeButton = clonedGame.querySelector('.buttons-container .change-btn');
            changeButton.addEventListener('click',(e) => changeGameInfo(e));
            
            const deleteButton = clonedGame.querySelector('.buttons-container .delete-btn');
            deleteButton.addEventListener('click', (e) => deleteGame(e));
            
            gamesContainer.appendChild(clonedGame);
        }
    });
}

async function addGame(){
    const name = gameNameInputElement.value;
    const players = gameMaxPlayersInputElement.value;
    const type = gameTypeInputElement.value;

    await requester.post({name, players, type});
    
    gameNameInputElement.value = '';
    gameTypeInputElement.value = '';
    gameMaxPlayersInputElement.value = '';
    
    loadGames();
}

function changeGameInfo(e){
    const currentGame = e.target.parentElement.parentElement;
    const gameId = currentGame.id;
    
    const contentElements = currentGame.querySelectorAll('div.content p');
    
    gameNameInputElement.value = contentElements[0].textContent;
    gameTypeInputElement.value = contentElements[1].textContent;
    gameMaxPlayersInputElement.value = contentElements[2].textContent;
    
    addButton.setAttribute('disabled', 'disabled');
    editButton.removeAttribute('disabled');
    
    gamesContainer.removeChild(currentGame);
    
    editButton.addEventListener('click', () => editGame(gameId));
}

async function editGame(gameId){
    editButton.setAttribute('disabled', 'disabled');
    addButton.removeAttribute('disabled');
    
    await requester.put(gameId, {name:gameNameInputElement.value, players: gameMaxPlayersInputElement.value, type: gameTypeInputElement.value});
    
    gameNameInputElement.value = '';
    gameTypeInputElement.value = '';
    gameMaxPlayersInputElement.value = '';
    loadGames();
}

async function deleteGame(e){
    const currentGame = e.target.parentElement.parentElement;
    const gameId = currentGame.id;

    await requester.delete(gameId);

    loadGames();
}
