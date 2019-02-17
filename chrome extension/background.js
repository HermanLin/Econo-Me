console.log('background running');

chrome.browserAction.onClicked.addListener(buttonClicked);

function buttonClicked(tab) {
    //console.log("buttonclicked!");

    chrome.tabs.query({
        active: true,
        currentWindow: true
    }, function() {
        let info = {
            currentUrl: tab.url,
            currentTitle: tab.title
        }
        console.log("url getted");
        chrome.tabs.sendMessage(tab.id, info);
    });

    chrome.windows.create({
        url: 'popup.html',
        type: 'popup',
        left: screen.width/2,
        top: screen.height/2,
        width: 300,
        height: 200
    }, function(window) {
    });
    
    //console.log(tab);
}

function test(){
    alert("tested");
}

document.addEventListener('DOMContentLoaded', function() {
    var link = document.getElementById('addToWish');
    // onClick's logic below:
    link.addEventListener('click', function() {
        test();
    });
});
