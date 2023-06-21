-- 1. Вывести название и стоимость в USD одного самого дорогого проданного товара
select  
	products.ProductName,
    products.Price * 1.4 as Price_usd 
from products
join order_details on products.ProductID=order_details.ProductID
order by products.Price desc
limit 1;

-- 2. Вывести два самых дорогих товара из категории Beverages из USA
select *
from products
join categories on products.CategoryID=categories.CategoryID
where categories.CategoryName = 'Beverages'
order by products.Price desc
limit 2;

-- 3. Вывести заказы, добавив поле доставлено (или нет), учитывая, что доставлены только 10248 и 10249
select *,
	case 
    when OrderID in (10248,10249) then 'доставлено'
    else  'не доставлено'
end as Delivery_status
from orders;

-- 4. Вывести список стран, которые поставляют морепродукты
select distinct suppliers.Country
from products
join categories on products.CategoryID=categories.CategoryID
join suppliers on products.SupplierID=suppliers.SupplierID
where categories.CategoryName='Seafood';


-- 5. Очистить поле ContactName у всех клиентов не из China
update customers
set ContactName=''
where 
	not Country = 'China';

