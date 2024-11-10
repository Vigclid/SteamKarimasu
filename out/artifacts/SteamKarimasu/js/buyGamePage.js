
function handleConfirm(event) {
    event.preventDefault();
    if (window.username.includes("Guest")) {
        alert("You must log in to do this");
    } else {
        event.target.submit();
    }
}