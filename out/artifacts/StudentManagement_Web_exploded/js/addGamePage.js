const uploadBox = document.getElementById('uploadBox');
const mainPreviewImage = document.getElementById('mainPreviewImage');
const mainFileInput = document.getElementById('mainFileInput');
const mainPlusButton = document.getElementById('mainPlusButton');
const thumbnailContainer = document.getElementById('thumbnailContainer');
const maxThumbnails = 4;

// Thêm sự kiện chọn file cho nút "+"
mainPlusButton.addEventListener('click', () => {
  mainFileInput.click();
});

// Hiển thị ảnh khi chọn từ file
mainFileInput.addEventListener('change', () => {
  const file = mainFileInput.files[0];
  if (file && file.type.startsWith('image/')) {
    showPreview(mainPreviewImage, file);
    mainPlusButton.style.display = 'none';
  }
});

// Cho phép người dùng chọn lại ảnh khi nhấp vào ảnh chính
mainPreviewImage.addEventListener('click', () => {
  mainFileInput.click();
});

// Thêm sự kiện kéo-thả ảnh vào khung upload-box
uploadBox.addEventListener('dragover', (e) => {
  e.preventDefault();
  uploadBox.classList.add('dragover');
});

uploadBox.addEventListener('dragleave', () => {
  uploadBox.classList.remove('dragover');
});

uploadBox.addEventListener('drop', (e) => {
  e.preventDefault();
  uploadBox.classList.remove('dragover');
  const file = e.dataTransfer.files[0];
  if (file && file.type.startsWith('image/')) {
    showPreview(mainPreviewImage, file);
    mainPlusButton.style.display = 'none';
  }
});

// Hàm hiển thị ảnh cho khung chính và thumbnail
function showPreview(imgElement, file) {
  const reader = new FileReader();
  reader.onload = function(event) {
    imgElement.src = event.target.result;
    imgElement.style.display = 'block';
  }
  reader.readAsDataURL(file);
}

// Tạo thumbnail box và thêm tính năng chọn file
function createThumbnailBox() {
  const thumbnailBox = document.createElement('div');
  thumbnailBox.classList.add('thumbnail-box');
  
  const thumbnailImg = document.createElement('img');
  thumbnailBox.appendChild(thumbnailImg);

  const thumbnailFileInput = document.createElement('input');
  thumbnailFileInput.type = 'file';
  thumbnailFileInput.accept = 'image/*';
  thumbnailFileInput.style.display = 'none';

  thumbnailBox.appendChild(thumbnailFileInput);

  // Chọn ảnh khi nhấn vào thumbnail
  thumbnailBox.addEventListener('click', () => {
    thumbnailFileInput.click();
  });

  // Hiển thị ảnh khi chọn file cho thumbnail
  thumbnailFileInput.addEventListener('change', () => {
    const file = thumbnailFileInput.files[0];
    if (file && file.type.startsWith('image/')) {
      showPreview(thumbnailImg, file);
      addNewThumbnailBoxIfNeeded();
    }
  });

  thumbnailContainer.appendChild(thumbnailBox);
}

// Thêm khung thumbnail mới nếu chưa đạt maxThumbnails
function addNewThumbnailBoxIfNeeded() {
  const currentThumbnails = thumbnailContainer.getElementsByClassName('thumbnail-box');
  if (currentThumbnails.length < maxThumbnails) {
    createThumbnailBox();
  }
}

// Khởi tạo thumbnail box đầu tiên
addNewThumbnailBoxIfNeeded();