let MY_BANK = {

    BANK_ID : "970422", //MB Bank
    ACCOUNT_NO : "0356759177",
    TEMPLATE: "qr_only",
    ACCOUNT_NAME: "Doan Xuan Son"
}
let isSucess = false;
let AmountPayment = [
    { amountID: "10k", amount: "10000" },
    { amountID: "20k", amount: "20000" },
    { amountID: "50k", amount: "50000" },
    { amountID: "100k", amount: "100000" },
    { amountID: "200k", amount: "200000" },
    { amountID: "500k", amount: "500000" }
];
let App_Script = "https://script.google.com/macros/s/AKfycbxRLH9OA9EeP9LWfdEMvKDclaGwh9fes1SaXc1STips-Qt71ECGBLhhgzK42PkEWB9U/exec";
document.addEventListener("DOMContentLoaded", () => {
    //Thong tin co ban khi chuyen khoan
    const amountDisplay = document.querySelector('.amount p');
    let CurrentAmount, CurrentAmountID;


    //Ảnh khi click vào từng mục
    var img = document.createElement('img');



    let AmountPayment = [
        { amountID: "10k", amount: "10000" },
        { amountID: "20k", amount: "20000" },
        { amountID: "50k", amount: "50000" },
        { amountID: "100k", amount: "100000" },
        { amountID: "200k", amount: "200000" },
        { amountID: "500k", amount: "500000" }
    ];

    AmountPayment.forEach((item, index) => {
        const button = document.getElementById(`btn${index + 1}`);
        if (button) {
            button.value = item.amountID;
            button.dataset.amount = item.amount;
            button.dataset.amountID = item.amountID;
            let QR = "https://img.vietqr.io/image/" + MY_BANK.BANK_ID + "-" +
                MY_BANK.ACCOUNT_NO + "-" + MY_BANK.TEMPLATE + ".png?amount=" + item.amount +
                "&addInfo="+window.username+"&accountName=" + MY_BANK.ACCOUNT_NAME;
            // Add a click event listener for each button


            button.addEventListener('click', () => {
                CurrentAmount = item.amount;
                CurrentAmountID = item.amountID;

                isSucess = false;

                if (window.username.includes("Guest")){
                    alert("You must login to do payment!");
                } else
                // Update the <p> element with the selected values
                if (amountDisplay) {
                    img.src = QR;
                    img.alt = "Ma QR"
                    document.querySelector('.deposit-qr').appendChild(img);
                    amountDisplay.innerHTML = `Your choice: ${CurrentAmount}`;
                }
                paidPrice = item.amount;
                paidContent = window.username;
                console.log(paidContent + " " + paidPrice)

                checkPaid(paidPrice, paidContent);


            });
        }
    });
});


async function checkPaid(price,content){

        try {
            const response = await fetch(App_Script);
            const data = await response.json();
            const lastPaid = data.data[data.data.length - 1];
            lastPrice = lastPaid["Giá trị"];
            lastContent = lastPaid["Mô tả"];

            console.log("lastPrice: "+lastPrice + ", lastContent: "+lastContent +", price: "+price+", content: "+content);
            if (isSucess)
                return;

            if (parseInt(lastPrice) === parseInt(price) && lastContent.includes(content)) {
                isSucess = true;
                alert("Successful purchase "+price);
                successProcess(lastPaid["Mã GD"], price);
            } else {
                console.log("Chua thanh cong / That bai");

                setTimeout(() => {
                    checkPaid(price, content);
                }, 100);
            }
        } catch (err){
            console.error("Lỗi");
        }

}




function successProcess(MaGiaoDich, Amount) {
    showCountdown()

    document.getElementById('MaGiaoDich').value = MaGiaoDich;
    document.getElementById('amount').value = Amount;

    // Tự động gửi form mà không cần người dùng nhấn nút
    showCountdown(() => {
        // Tự động gửi form khi đếm ngược hoàn tất
        document.getElementById('myForm').submit();
    });
}


function showCountdown(onCountdownComplete) {
    const countdownElement = document.getElementById('countdown');
    countdownElement.style.display = 'block'; // Hiện modal
    document.body.style.pointerEvents = 'none';

    let count = 5;
    countdownElement.innerText = "Home page in " + count; // Hiển thị số đếm

    const interval = setInterval(() => {
        count--;
        countdownElement.innerText = "Home page in " + count; // Cập nhật số đếm

        if (count <= 0) {
            clearInterval(interval); // Dừng đếm khi đến 0
            countdownElement.style.display = 'none'; // Ẩn modal
            document.body.style.pointerEvents = 'auto'; // Cho phép tương tác trở lại

            // Gọi hàm khi đếm ngược hoàn tất
            if (typeof onCountdownComplete === 'function') {
                onCountdownComplete();
            }
        }
    }, 1000); // Đếm mỗi giây
}



















//PHÁ



