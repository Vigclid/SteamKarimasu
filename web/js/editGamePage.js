const mainPreviewImage = document.getElementById('mainPreviewImage');
const mainFileInput = document.getElementById('mainFileInput');
const thumbnailContainer = document.getElementById('thumbnailContainer');
const maxThumbnails = 4;

// Lấy dữ liệu JSON từ thẻ script
const imageData = JSON.parse(document.getElementById('imageData').textContent);

// Hiển thị ảnh chính từ JSON
function showMainImage(url) {
    mainPreviewImage.src = url;
    mainPreviewImage.style.display = 'block';
}

// Hiển thị ảnh thumbnail từ JSON hoặc ô trống
function showThumbnail(url) {
    const thumbnailBox = document.createElement('div');
    thumbnailBox.classList.add('thumbnail-box');

    if (url) {
        const thumbnailImg = document.createElement('img');
        thumbnailImg.src = url;
        thumbnailBox.appendChild(thumbnailImg);
    } else {
        thumbnailBox.classList.add('empty');

    }

    // Cho phép thay ảnh thumbnail khi người dùng nhấn vào
    const thumbnailFileInput = document.createElement('input');
    thumbnailFileInput.type = 'file';
    thumbnailFileInput.accept = 'image/*';
    thumbnailFileInput.style.display = 'none';

    thumbnailBox.appendChild(thumbnailFileInput);

    thumbnailBox.addEventListener('click', () => {
        thumbnailFileInput.click();
    });

    thumbnailFileInput.addEventListener('change', () => {
        const file = thumbnailFileInput.files[0];
        if (file && file.type.startsWith('image/')) {
            const reader = new FileReader();
            reader.onload = function(event) {
                thumbnailBox.innerHTML = ''; // Xóa nội dung hiện tại
                const newImg = document.createElement('img');
                newImg.src = event.target.result;
                thumbnailBox.appendChild(newImg);
            }
            reader.readAsDataURL(file);
        }
    });

    thumbnailContainer.appendChild(thumbnailBox);
}

// Khởi tạo các ảnh đã lưu từ JSON
function initSavedImages() {
    if (imageData.mainImage) {
        showMainImage(imageData.mainImage);
    }

    const thumbnails = imageData.thumbnails.slice(0, maxThumbnails);
    thumbnails.forEach(url => showThumbnail(url));

    // Hiển thị các ô trống nếu cần
    const emptyThumbnailsCount = maxThumbnails - thumbnails.length;
    for (let i = 0; i < emptyThumbnailsCount; i++) {
        showThumbnail(null); // Thêm ô trống
    }
}

// Cho phép người dùng chọn lại ảnh chính
mainPreviewImage.addEventListener('click', () => {
    mainFileInput.click();
});

mainFileInput.addEventListener('change', () => {
    const file = mainFileInput.files[0];
    if (file && file.type.startsWith('image/')) {
        const reader = new FileReader();
        reader.onload = function(event) {
            mainPreviewImage.src = event.target.result;
        }
        reader.readAsDataURL(file);
    }
});

// Khởi tạo các ảnh từ JSON
initSavedImages();