window.onload = function() {
    const gameTable = document.getElementById('table-game');

    // Lấy tất cả các ô game có trong bảng
    const gameCells = gameTable.querySelectorAll('.game-cell');

    let row;

    gameCells.forEach((cell, index) => {
        // Nếu chưa có hàng hoặc đã đủ 5 game trong hàng, tạo hàng mới
        if (index % 5 === 0) {
            row = document.createElement('tr');
            gameTable.appendChild(row);
        }
        // Thêm ô game vào hàng
        row.appendChild(cell);
    });
};

function toggleSortBy() {
    var sidebar = document.getElementById("sort-by-table");
    sidebar.classList.toggle("active");

    var arrow = document.querySelector("#sort-by .arrow");
    arrow.classList.toggle("rotated");
}
