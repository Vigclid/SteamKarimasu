let MY_BANK = {

    BANK_ID : "970422", //MB Bank
    ACCOUNT_NO : "0356759177",
    TEMPLATE: "qr_only",
    AMOUNT: "10000",
    ACCOUNT_NAME: "Doan Xuan Son"
}
let AmountPayment = [
    { amountID: "10k", amount: "10000" },
    { amountID: "20k", amount: "20000" },
    { amountID: "50k", amount: "50000" },
    { amountID: "100k", amount: "100000" },
    { amountID: "200k", amount: "200000" },
    { amountID: "500k", amount: "500000" }
];
document.addEventListener("DOMContentLoaded", () => {
    AmountPayment.forEach((item, index) => {
        const button = document.getElementById(`btn${index + 1}`);
        if (button) {
            button.value = item.amountID;
            button.dataset.amount = item.amount;
        }
    });
});
// document.addEventListener("DOMContentLoaded", function() {
//     // URL hình ảnh bạn muốn hiển thị
//     const imageUrl = "https://img.vietqr.io/image/" + MY_BANK.BANK_ID + "-" + MY_BANK.ACCOUNT_NO + "-" + MY_BANK.TEMPLATE + ".png?amount=" + MY_BANK.AMOUNT + "&addInfo=10k&accountName=" + MY_BANK.ACCOUNT_NAME;
//     // Tạo phần tử hình ảnh
//     const img = document.createElement("img");
//     img.src = imageUrl;
//     img.alt = "QR Bank";
//
//     // Thêm hình ảnh vào thẻ div
//     // Tìm phần tử có class "deposit-qr"
//     const container = document.querySelector(".deposit-qr");
//     if (container) {
//         container.appendChild(img);
//     } else {
//         console.error("Không tìm thấy thẻ div với class 'deposit-qr'");
//     }
//
//     paidPrice = "10000";
//     paidContent = "10k";
//
//
//     setInterval(() => {
//         checkPaid(paidPrice,paidContent);
//     }, 1000);
//
//
// });

let App_Script = "https://script.googleusercontent.com/macros/echo" +
    "?user_content_key=XDgcasciJX67JmI3l1BHbfFWWmTdWNV6QekbGOtN9OAFrPtjAAr3nCLr" +
    "oS0y2cNs_7Ph1KgaRBpUceSxcxIX_hunjGNCaaDtm5_BxDlH2jW0nuo2oDemN9CCS2h10ox_1xSncGQajx_ryfhECjZEnPI2TC" +
    "XxOtUO9wz9HAO-UMW8LJ5KcWWYWTAzrjzyON0s0h09Pyx-LeRP6-BiDyPpmE04dhJ7EKtBdHqPpjDSM" +
    "Xz0yTOVXVLMLQ&lib=Mmu6QPQpV6yM10SFGJpMOxaisV3GZFA2q";

async function checkPaid(price,content){
    try {
        const response = await fetch(App_Script);
        const data = await response.json();
        const lastPaid = data.data[data.data.length -1 ];
        lastPrice = lastPaid["Giá trị"];
        lastContent = lastPaid["Mô tả"];
        if (lastPrice >= price && lastContent.includes(content) ){
            alert("Thanh cong: Last Price: "+lastPrice + ": LastContent: " + lastContent + "Price: "+price + ": content: "+content);
        } else {
            alert("That bai: Last Price: "+lastPrice + ": LastContent: " + lastContent + "Price: "+price + ": content: "+content);
        }
    } catch {
        console.error("Lỗi");
    }
}