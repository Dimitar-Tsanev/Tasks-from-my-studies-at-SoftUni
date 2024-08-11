function attachEvents() {
    // TODO:
    const loadPostsButton = document.getElementById('btnLoadPosts');
    const viewPostButton = document.getElementById('btnViewPost');

    const selectElement = document.getElementById('posts');

    loadPostsButton.addEventListener('click', loadPosts);

    let postsMap = new Map();

    function loadPosts(){
        const url = 'http://localhost:3030/jsonstore/blog/posts';

        fetch(url)
            .then(response => response.json())
            .then(result =>{
                for (const idKey in result) {
                   const{body, id, title} = result[idKey];
                   const optionElement = document.createElement('option');
                   optionElement.value = id;
                   optionElement.textContent = title;

                   postsMap.set(id, {title, body});

                   selectElement.appendChild(optionElement);
                }
            });
        viewPostButton.addEventListener('click', getComments)
    }

    function getComments(){
        const url = 'http://localhost:3030/jsonstore/blog/comments';
        
        const headerElementForTitle = document.getElementById('post-title');
        const elementForBody = document.getElementById('post-body');
        
        headerElementForTitle.textContent = postsMap.get(selectElement.value)['title'];
        elementForBody.textContent = postsMap.get(selectElement.value)['body'];

        const commentsElement = document.getElementById('post-comments');
        commentsElement.innerHTML = '';
        
        fetch(url)
            .then(response => response.json())
            .then(result => {
                for (const idKey in result) {
                    const{id, postId, text} = result[idKey];
                    if (postId === selectElement.value){
                        const liElement = document.createElement('li');
                        liElement.textContent = text;

                        commentsElement.appendChild(liElement);
                    }
                }
              
            });
    }
}

attachEvents();