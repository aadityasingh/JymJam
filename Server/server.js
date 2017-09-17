var net = require('net');
var sockets = [];
 
//todo: implement trainers & trainees, implement request buffer for possible tiebreaker situations
//implement better time specification for buddies

class Buddy
{
    constructor(name, phone, gym, time, workout, level)
    {
        this.name = name;
        this.phone = phone;
        this.gym = gym;
        this.time = time;
        this.workout = workout;
        this.level = level;
        this.available = true;
    }
}

//var buddypool = [];
var buddypool = [[new Buddy("A", "603", "Maseeh", 0, "gh"), new Buddy("B", "232", "Maseeh", 0, "gh")]];
function pushBuddy(name, phone, gym, time, workout, level)
{
    timerange = parseTimeToRange(time); //probably apply before passing to args
    buddypool[timerange].push(new Buddy(name, phone, gym, time, workout));
}
function parseTimeToRange(time){
    if (time == ''){

    }
}
function formPairs(time)
{
    var i;
    var finalMatches = [];
    for(i = 0; i < buddypool[time].length-1; i++)
    {
        if(buddypool[time][i].available == false)
        {
            continue
        }
        else
        {
            var matches = []; 
            for(j = i+1; j < buddypool[time].length; j++)
            {
                if(buddypool[time][j].available == false)
                {
                    continue
                }
                else
                {
                    if(buddypool[time][i].gym == buddypool[time][j].gym)
                    {
                        matches.push(j);
                        console.log(Boolean(buddypool[time][i].gym == buddypool[time][j].gym));
                    }
                }
            }

            for (j=0; j<matches.length; j++)
            {
                //console.log(Boolean(buddypool[time][i].gym == matches[j].gym));
                //console.log(buddypool[time][i].gym);
                //console.log(matches[j].gym);
                if (buddypool[time][matches[j]].gym == buddypool[time][i].gym)
                {
                    buddypool[time][matches[j]].available = false;
                    buddypool[time][i].available=false;
                    finalMatches[i] = buddypool[time][matches[j]];
                    finalMatches[matches[j]] = buddypool[time][i];
                    break;
                }
      
            }
            if (buddypool[time][i].available == true)
            {
                finalMatches[i]=null;
                buddypool[time][i].available = false;
            }
        }
    }
    return finalMatches
}
//('10.6.182.8.84:88')

console.log(formPairs(0));

var svr = net.createServer(function(sock) 
{
    console.log('Connected: ' + sock.remoteAddress + ':' + sock.remotePort);
    sockets.push(sock);
 
    sock.write('Welcome to the server!\n');
 
    sock.on('data', function(data) 
	{
        console.log(data);
        var datasplit = data.split("$");
        //var str = datasplit[0]+datasplit[1];
        sockets[i].write("Campus Police$6172531212");
        //data received is a new buddy; add to queue in correct index
        /*
        for (var i=0; i<sockets.length ; i++) 
		{
            if (sockets[i] != sock) 
			{
                if (sockets[i]) 
				{
                    sockets[i].write(data);
                }
            }
        }*/
    });
 
    sock.on('end', function() 
	{
        console.log('Disconnected: ' + sock.remoteAddress + ':' + sock.remotePort);
        var idx = sockets.indexOf(sock);
        if (idx != -1) 
		{
            delete sockets[idx];
        }
    });
});
 
//var svraddr = '192.168.0.8';
var svraddr = '10.182.6.84';
//var svraddr = '127.0.0.1';
var svrport = 1234;
 
svr.listen(svrport, svraddr);
console.log('Server Created at ' + svraddr + ':' + svrport + '\n');
