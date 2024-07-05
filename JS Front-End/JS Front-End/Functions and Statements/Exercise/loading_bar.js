function percentToVisualize(percent){
    const bar = `[${'%'.repeat(percent / 10).concat('.'.repeat((100 - percent) /10))}]`;
    
    if (percent === 100){
        console.log(`${percent}% Complete!`);
        console.log(bar);

    }else{
        console.log(`${percent}% ${bar}`);
        console.log('Still loading...');
    }
}
percentToVisualize(30);
percentToVisualize(50);
percentToVisualize(100);