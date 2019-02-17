console.log("econo-me go");

chrome.runtime.onMessage.addListener(gotUrl);

function gotUrl(info, sender, sendResponse) {
    //alert(info.currentUrl);
}