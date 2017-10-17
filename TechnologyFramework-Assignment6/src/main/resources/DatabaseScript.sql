CREATE DATABASE shopping_cart;

USE shopping_cart;

CREATE TABLE IF NOT EXISTS product (
    product_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    price FLOAT NOT NULL,
    description VARCHAR(1000) NOT NULL,
    imageUrl VARCHAR(500) NOT NULL,
    quantity INT NOT NULL
);

CREATE TABLE IF NOT EXISTS user (
    user_mail_id VARCHAR(500) PRIMARY KEY,
    password VARCHAR(50) NOT NULL,
    name VARCHAR(100) NOT NULL,
    type VARCHAR(1) CHECK(type IN("A", "C"))
);

CREATE TABLE IF NOT EXISTS order_details (
    order_id INT PRIMARY KEY AUTO_INCREMENT,
    product_id INT,
    price FLOAT NOT NULL,
    quantity INT NOT NULL,
    amount FLOAT NOT NULL,
    FOREIGN KEY(product_id) REFERENCES product(product_id) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS orders (
    order_no INT PRIMARY KEY AUTO_INCREMENT,
    order_id INT,
    user_mail_id VARCHAR(500),
    order_date DATETIME,
    status VARCHAR(1) CHECK(status IN("P", "C")), 
    FOREIGN KEY(order_id) REFERENCES order_details(order_id) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY(user_mail_id) REFERENCES user(user_mail_id) ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO product VALUES
( 1, 'Badminton', 450, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam volutpat ante in tempor efficitur. Nulla sit amet tristique arcu, a finibus sem. Donec pulvinar suscipit lorem a iaculis. Maecenas non aliquet ipsum. ', 'https://www.proprofs.com/quiz-school/topic_images/p18ku126q51c46fj81tg013m613nu3.png', 5 ),
( 2, 'Football', 650, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam volutpat ante in tempor efficitur. Nulla sit amet tristique arcu, a finibus sem. Donec pulvinar suscipit lorem a iaculis. Maecenas non aliquet ipsum. ', 'https://shop.savethechildren.org.uk/wp-content/uploads/2016/10/football-1.png', 10 ),
( 3, 'Cricket Set', 5900, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam volutpat ante in tempor efficitur. Nulla sit amet tristique arcu, a finibus sem. Donec pulvinar suscipit lorem a iaculis. Maecenas non aliquet ipsum. ', 'https://images-na.ssl-images-amazon.com/images/I/71TUNCQxJTL._SL1500_.jpg', 20 ),
( 4, 'Basket Ball', 840, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam volutpat ante in tempor efficitur. Nulla sit amet tristique arcu, a finibus sem. Donec pulvinar suscipit lorem a iaculis. Maecenas non aliquet ipsum. ', 'https://assets.primesport.com/prod/images/Generic%20Basketball%20Logo.png', 5 ),
( 5, 'Volley Ball', 470, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam volutpat ante in tempor efficitur. Nulla sit amet tristique arcu, a finibus sem. Donec pulvinar suscipit lorem a iaculis. Maecenas non aliquet ipsum. ', 'https://yt3.ggpht.com/-0zo3UN2TACg/AAAAAAAAAAI/AAAAAAAAAAA/2zANjbHjEZQ/s900-c-k-no-mo-rj-c0xffffff/photo.jpg', 10),
( 6, 'Watch', 12000, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam volutpat ante in tempor efficitur. Nulla sit amet tristique arcu, a finibus sem. Donec pulvinar suscipit lorem a iaculis. Maecenas non aliquet ipsum. ', 'https://content.rolex.com/is/image/Rolex/?src=is%7BRolex%2Fshadow_cellini_moonphase_39%3Flayer%3D1%26src%3D50776%26layer%3D2%26src%3D50771_p_39%26layer%3D3%26src%3D50769%7D&$rv55-watch-grid-retina$', 50),
( 7, 'shoes', 1500, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam volutpat ante in tempor efficitur. Nulla sit amet tristique arcu, a finibus sem. Donec pulvinar suscipit lorem a iaculis. Maecenas non aliquet ipsum. ', 'https://rukminim1.flixcart.com/image/1408/1408/shoe/y/6/e/wonder-13-45-asian-grey-original-imaenr72gssfxrbj.jpeg?q=90', 80),
( 8, 'Treadmill', 3500, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam volutpat ante in tempor efficitur. Nulla sit amet tristique arcu, a finibus sem. Donec pulvinar suscipit lorem a iaculis. Maecenas non aliquet ipsum. ', 'http://shop.lifefitness.com/UserFiles/Images/Products/F3-Treadmill-Go-Console-L.jpg', 70),
( 9, 'Sports Cycle', 6800, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam volutpat ante in tempor efficitur. Nulla sit amet tristique arcu, a finibus sem. Donec pulvinar suscipit lorem a iaculis. Maecenas non aliquet ipsum. ', 'https://5.imimg.com/data5/XC/LK/MY-24806022/sport-cycle-500x500.jpg', 10 ),
( 10, 'Boxing gloves', 980, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam volutpat ante in tempor efficitur. Nulla sit amet tristique arcu, a finibus sem. Donec pulvinar suscipit lorem a iaculis. Maecenas non aliquet ipsum. ', 'http://www.twinsfightgear.com/assets/images/BoxingGloves_bgvl3red.jpg', 90),
( 11, 'Chess', 1400, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam volutpat ante in tempor efficitur. Nulla sit amet tristique arcu, a finibus sem. Donec pulvinar suscipit lorem a iaculis. Maecenas non aliquet ipsum. ', 'https://cdn6.bigcommerce.com/s-5p6k1/product_images/e/plastic-chess-sets-banner-310__49082.jpg', 40 ),
( 12, 'Table Tennis set', 1896, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam volutpat ante in tempor efficitur. Nulla sit amet tristique arcu, a finibus sem. Donec pulvinar suscipit lorem a iaculis. Maecenas non aliquet ipsum. ', 'https://images-na.ssl-images-amazon.com/images/I/51xOvmxUgJL._SX355_.jpg', 10 ),
( 13, 'Baseball Bat', 874, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam volutpat ante in tempor efficitur. Nulla sit amet tristique arcu, a finibus sem. Donec pulvinar suscipit lorem a iaculis. Maecenas non aliquet ipsum. ', 'https://www.baseballsavings.com/wcsstore/CatalogAssetStore/Attachment/images/products/baseball/P30947/cfli-ap5albertpujolsblacknatural.jpg', 50),
( 14, 'Dumbbells', 638, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam volutpat ante in tempor efficitur. Nulla sit amet tristique arcu, a finibus sem. Donec pulvinar suscipit lorem a iaculis. Maecenas non aliquet ipsum. ', 'https://s7d2.scene7.com/is/image/dkscdn/16BFXUSLCTTCHDMBBSLC_is', 20 ),
( 15, 'Badminton Net', 460, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam volutpat ante in tempor efficitur. Nulla sit amet tristique arcu, a finibus sem. Donec pulvinar suscipit lorem a iaculis. Maecenas non aliquet ipsum. ', 'http://www.mantis-sport.com/images/stories/shop/product/TSM003_3M-Badminton_Net.png', 80 ),
( 16, 'Cricket Ball', 150, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam volutpat ante in tempor efficitur. Nulla sit amet tristique arcu, a finibus sem. Donec pulvinar suscipit lorem a iaculis. Maecenas non aliquet ipsum. ', 'https://cdn.shopify.com/s/files/1/1126/9634/products/Gray_Nicolls_Aut_4dc38d30198c3.jpeg?v=1457417337', 70);


INSERT INTO user VALUES
( 'user1@shoppystore.com', 'user1', 'User1', 'C' ),
( 'user2@shoppystore.com', 'user2', 'User2', 'A' ),
( 'user3@shoppystore.com', 'user3', 'User3', 'C' ),
( 'user4@shoppystore.com', 'user4', 'User4', 'C' );