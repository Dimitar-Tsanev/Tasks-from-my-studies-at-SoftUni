function invokeSongsList(mixedData){
    class Song{
        constructor(listType, songName, songDuration){
            this.listType = listType;
            this.name = songName;
            this.duration = songDuration;
        }
        
        getListType(){
            return this.listType;
        }
        
        getName(){
            return this.name;
        }
    }
    const invokeAll = 'all';
    const [numberOfSongs, ...dataLeft] = mixedData;
    const typeOfListToInvoke = dataLeft[dataLeft.length - 1];
    const songs = [];
    
    for(let i = 0; i < numberOfSongs; i++){
        const songData = dataLeft[i].split(/_/);
        
        const song = new Song(songData[0], songData[1], songData[2]);
        
        songs.push(song);
    }

    if (typeOfListToInvoke === invokeAll){
        for (const song of songs) {
            console.log (song.getName()); 
        }
        return;
    }

    for (const song of songs) {
        if (song.getListType() === typeOfListToInvoke){
            console.log (song.getName());
        }
    }
}
invokeSongsList([3, 'favourite_DownTown_3:14', 'favourite_Kiss_4:16', 'favourite_Smooth Criminal_4:01', 'favourite'] );
invokeSongsList([4, 'favourite_DownTown_3:14', 'listenLater_Andalouse_3:24', 'favourite_In To The Night_3:58', 'favourite_Live It Up_3:48', 'listenLater'] );
invokeSongsList([2, 'like_Replay_3:15', 'ban_Photoshop_3:48', 'all']);
