console.log('background running');

chrome.browserAction.onClicked.addListener(buttonClicked);

function buttonClicked(tab) {
    //console.log("buttonclicked!");

    chrome.tabs.query({
        active: true,
        currentWindow: true,
        //windowId: chrome.windows.WINDOW_ID_CURRENT
    }, function() {
        let info = {
            currentUrl: tab.url,
            currentId: tab.id
        }
        console.log("url getted");
        chrome.tabs.sendMessage(tab.id, info);
    });
    
    //console.log(tab);
}


