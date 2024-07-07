function createSchedule(meetings){
    let schedule = new Map();
    
    for (const meeting of meetings) {
        let day = meeting.split(/\s+/)[0];
        let personName = meeting.split(/\s+/)[1];
        
        if(schedule.has(day)){
            console.log (`Conflict on ${day}!`)
            
        }else{
            schedule.set(day, personName);
            console.log(`Scheduled for ${day}`)
        }
    }
    for (const meeting of schedule) {
        console.log(`${meeting[0]} -> ${meeting[1]}`)
    }
}
createSchedule(['Monday Peter', 'Wednesday Bill', 'Monday Tim', 'Friday Tim']);