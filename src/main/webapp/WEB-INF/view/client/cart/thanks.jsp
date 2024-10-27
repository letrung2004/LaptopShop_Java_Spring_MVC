<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <!DOCTYPE html>
    <html lang="vi">

    <head>
        <meta charset="UTF-8">
        <title>Đặt Hàng Thành Công</title>
        <style>
            /* CSS nhúng */
            * {
                margin: 0;
                padding: 0;
                box-sizing: border-box;
                font-family: Arial, sans-serif;
            }

            body {
                background-color: #f3f4f6;
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
            }

            .container {
                width: 100%;
                max-width: 500px;
                padding: 20px;
                text-align: center;
            }

            .success-box {
                background-color: #ffffff;
                padding: 30px;
                border-radius: 10px;
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            }

            h1 {
                font-size: 24px;
                color: #2c7a7b;
                margin-bottom: 20px;
            }

            p {
                font-size: 16px;
                color: #4a5568;
                margin-bottom: 30px;
            }

            .back-btn {
                display: inline-block;
                padding: 10px 20px;
                background-color: #38a169;
                color: #ffffff;
                border-radius: 5px;
                text-decoration: none;
                font-weight: bold;
                transition: background-color 0.3s;
            }

            .back-btn:hover {
                background-color: #2f855a;
            }
        </style>
    </head>

    <body>
        <div class="container">
            <div class="success-box">
                <h1>Đặt Hàng Thành Công!</h1>
                <p>Cảm ơn bạn đã đặt hàng. Chúng tôi sẽ liên hệ với bạn trong thời gian sớm nhất để xác nhận đơn hàng.
                </p>
                <a href="/" class="back-btn">Quay lại trang chủ</a>
            </div>
        </div>
    </body>

    </html>