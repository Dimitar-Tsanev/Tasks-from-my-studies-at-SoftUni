function readMovies(input){
    let movieStorage = [];

    const addMovie = "addMovie ";
    const directedBy = " directedBy ";
    const onDate = " onDate ";

    input.forEach(data => {
        let movie;

        if(data.includes(addMovie)){
            let name = data.replace(addMovie, '');
            movieStorage.push({name});

        }else if(data.includes(directedBy)){
            let [name, director] = data.split(directedBy);

            movie = movieStorage.find(movie => movie.name === name );

            if(movie?.name){
                movie.director = director;
            }

        }else if (data.includes(onDate)){
            let [name, date] = data.split(onDate);

            movie = movieStorage.find(movie => movie.name === name );

            if(movie?.name){
                movie.date = date;
            }
        }
    });
    movieStorage.forEach(movie => {
        if(movie.name && movie.director && movie.date){
            console.log(JSON.stringify(movie));
        }
    });
}
readMovies([
    'addMovie Fast and Furious',
    'addMovie Godfather',
    'Inception directedBy Christopher Nolan',
    'Godfather directedBy Francis Ford Coppola',
    'Godfather onDate 29.07.2018',
    'Fast and Furious onDate 30.07.2018',
    'Batman onDate 01.08.2018',
    'Fast and Furious directedBy Rob Cohen'
    ]);
readMovies([
    'addMovie The Avengers',
    'addMovie Superman',
    'The Avengers directedBy Anthony Russo',
    'The Avengers onDate 30.07.2010',
    'Captain America onDate 30.07.2010',
    'Captain America directedBy Joe Russo'
    ]);
