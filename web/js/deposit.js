let MY_BANK = {

    BANK_ID : "970422", //MB Bank
    ACCOUNT_NO : "0356759177",
    TEMPLATE: "compact2",
    AMOUNT: "10000",
    ACCOUNT_NAME: "Doan Xuan Son"
}

document.addEventListener("DOMContentLoaded", function() {
    // URL hình ảnh bạn muốn hiển thị
    const imageUrl = "https://img.vietqr.io/image/" + MY_BANK.BANK_ID + "-" + MY_BANK.ACCOUNT_NO + "-" + MY_BANK.TEMPLATE + ".png?amount=" + MY_BANK.AMOUNT + "&addInfo=>&accountName=" + MY_BANK.ACCOUNT_NAME;
    // Tạo phần tử hình ảnh
    const img = document.createElement("img");
    img.src = imageUrl;
    img.alt = "QR Bank";

    // Thêm hình ảnh vào thẻ div
    // Tìm phần tử có class "deposit-qr"
    const container = document.querySelector(".deposit-qr");
    if (container) {
        container.appendChild(img);
    } else {
        console.error("Không tìm thấy thẻ div với class 'deposit-qr'");
    }
});

let fence = "https://script.googleusercontent.com/macros/echo?user_content_key=XDgcasciJX67JmI3l1BHbfFWWmTdWNV6QekbGOtN9OAFrPtjAAr3nCLroS0y2cNs_7Ph1KgaRBpUceSxcxIX_hunjGNCaaDtm5_BxDlH2jW0nuo2oDemN9CCS2h10ox_1xSncGQajx_ryfhECjZEnPI2TCXxOtUO9wz9HAO-UMW8LJ5KcWWYWTAzrjzyON0s0h09Pyx-LeRP6-BiDyPpmE04dhJ7EKtBdHqPpjDSMXz0yTOVXVLMLQ&lib=Mmu6QPQpV6yM10SFGJpMOxaisV3GZFA2q";