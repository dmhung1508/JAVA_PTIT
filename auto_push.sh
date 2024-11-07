#!/bin/bash

# Add tất cả các thay đổi
git add .

# Commit với một thông điệp mặc định hoặc có thể nhận tham số
git commit -m "${1:-Auto-update from Codespace}"

# Đẩy code lên nhánh hiện tại
git push origin "$(git rev-parse --abbrev-ref HEAD)"
