function showSearchItems() {
    const searchItems = document.getElementById("search-list-table");
    searchItems.style.height = "400px"; // Hiển thị danh sách với chiều cao cố định
    searchItems.style.overflow = "auto"; // Thêm thanh cuộn nếu nội dung vượt quá chiều cao
}

function filterSearchItems() {
    const input = document.getElementById("searchInput").value.toLowerCase();
    const tableRows = document.querySelectorAll("#search-list-table tbody tr");
    const searchItems = document.getElementById("search-list-table");

    tableRows.forEach(row => {
        const gameTitle = row.querySelector("input[type='submit']").value.toLowerCase();
        row.style.display = gameTitle.includes(input) ? "" : "none";
    });

    // Hiện/ẩn danh sách khi có hoặc không có kết quả
    if (input === "") {
        searchItems.style.height = "0";
        searchItems.style.overflow = "hidden";
    } else {
        showSearchItems(); // Gọi lại để giữ danh sách luôn hiện khi có giá trị nhập vào
    }
}