package com.guimei.shop.test;

import com.guimei.shop.bean.*;
import com.guimei.shop.dao.*;
import com.wang.java_util.GsonUtil;
import org.junit.Before;
import org.junit.Test;

/**
 * by wangrongjun on 2017/6/17.
 */
public class GuiMeiDaoTest {

    private GoodsTypeDao goodsTypeDao;
    private CustomerDao customerDao;
    private SellerDao sellerDao;
    private ShopDao shopDao;
    private GoodsDao goodsDao;
    private GoodsImageDao goodsImageDao;
    private OrdersDao ordersDao;
    private ShopCarDao shopCarDao;
    private EvaluateDao evaluateDao;
    private AddressDao addressDao;

    @Test
    public void testGuiMeiDao() {
        dropTableAndCreate();

        GoodsType ���Ӳ�Ʒ = new GoodsType("���Ӳ�Ʒ");
        GoodsType ʳƷ = new GoodsType("ʳƷ");
        goodsTypeDao.insert(���Ӳ�Ʒ);
        goodsTypeDao.insert(ʳƷ);
        goodsTypeDao.insert(new GoodsType("����"));
        goodsTypeDao.insert(new GoodsType("�ҵ�"));
        goodsTypeDao.insert(new GoodsType("���"));
        goodsTypeDao.insert(new GoodsType("�˶�"));
        goodsTypeDao.insert(new GoodsType("�鼮"));
        goodsTypeDao.insert(new GoodsType("����"));
        goodsTypeDao.insert(new GoodsType("����"));
        goodsTypeDao.insert(new GoodsType("����"));

        Seller ���� = new Seller("110", "123", "����", "���¹���", 0, "admin/img/seller_1.jpg");
        Seller ���� = new Seller("120", "123", "����", "����", 1, "admin/img/seller_2.jpg");
        Shop �������Գ� = new Shop(����, "�������Գ�", "ר�����Լ����豸", "admin/img/shop_1.jpg");
        Shop �ֻ��콢�� = new Shop(����, "�ֻ��콢��", "�������µ����ǣ�ƻ���ֻ�", "admin/img/shop_2.jpg");
        Shop ���ʵ� = new Shop(����, "���ʵ�", "��������ˮ�����߲�Ӧ�о��У�", "admin/img/shop_3.jpg");
        Shop ��ʳ�� = new Shop(����, "��ʳ��", "�Ի�Ԥ��Ӫ��", "admin/img/shop_4.jpg");

        Goods ����ʼǱ� = new Goods("����ʼǱ�", "Aspire���°�", 20, ���Ӳ�Ʒ, �������Գ�, 3200);
        Goods ƻ���ʼǱ� = new Goods("ƻ���ʼǱ�", "��������", 60, ���Ӳ�Ʒ, �������Գ�, 5400);
        Goods ����E7�ֻ� = new Goods("����E7�ֻ�", "E7ϵ��", 38, ���Ӳ�Ʒ, �ֻ��콢��, 1500);
        Goods iPhone7�ֻ� = new Goods("iPhone7�ֻ�", "�ǲ�˹Ż����Ѫ֮����", 8, ���Ӳ�Ʒ, �ֻ��콢��, 5000);
        Goods ���� = new Goods("����", "���ʵĲ���һ�����Ȼ��ũҩ", 200, ʳƷ, ���ʵ�, 7.5);
        Goods ƻ�� = new Goods("ƻ��", "���ʵ�ƻ��һ�����Ȼ��ũҩ", 80, ʳƷ, ���ʵ�, 11.2);
        Goods ���� = new Goods("����", "���ⶼ���ųԣ��������٣�", 250, ʳƷ, ��ʳ��, 2.5);
        Goods ���� = new Goods("����", "͸�������ķ��", 300, ʳƷ, ��ʳ��, 5);

        sellerDao.insert(����);
        sellerDao.insert(����);
        shopDao.insert(�������Գ�);
        shopDao.insert(�ֻ��콢��);
        shopDao.insert(���ʵ�);
        shopDao.insert(��ʳ��);
        goodsDao.insert(����ʼǱ�);
        goodsDao.insert(ƻ���ʼǱ�);
        goodsDao.insert(����E7�ֻ�);
        goodsDao.insert(iPhone7�ֻ�);
        goodsDao.insert(����);
        goodsDao.insert(ƻ��);
        goodsDao.insert(����);
        goodsDao.insert(����);

        Customer ���ٿ� = new Customer("15521302230", "123", "���ٿ�", "Ӣ��", 1, "admin/img/customer_1.jpg");
        Customer ĭĭ = new Customer("13023796942", "123", "ĭĭ", "ĭ����", 0, "admin/img/customer_2.jpg");

        customerDao.insert(���ٿ�);
        customerDao.insert(ĭĭ);

        shopCarDao.insert(new ShopCar(���ٿ�, iPhone7�ֻ�));
        shopCarDao.insert(new ShopCar(���ٿ�, ƻ���ʼǱ�));
        shopCarDao.insert(new ShopCar(ĭĭ, iPhone7�ֻ�));
        shopCarDao.insert(new ShopCar(ĭĭ, ƻ��));

        Address address1 = new Address(���ٿ�, "�����з�خ�����ݴ�ѧ��XXѧУXX����");
        Address address2 = new Address(ĭĭ, "��������������鶬����԰XX��XX��");
        addressDao.insert(address1);
        addressDao.insert(address2);

        Orders orders1 = new Orders(���ٿ�, ����E7�ֻ�, 1, ����E7�ֻ�.getPrice(), "15521302230", "Ӣ��", address1.getAddress(), "2016-04-14 15:34:12", 1);
        Orders orders2 = new Orders(���ٿ�, ����ʼǱ�, 1, ����ʼǱ�.getPrice(), "15521302230", "Ӣ��", address1.getAddress(), "2014-08-06 16:14:45", 1);
        Orders orders3 = new Orders(���ٿ�, ����, 6, ����.getPrice() * 6, "15521302230", "Ӣ��", address1.getAddress(), "2016-04-14 15:34:12", 0);
        Orders orders4 = new Orders(���ٿ�, ����, 10, ����.getPrice() * 10, "15521302230", "Ӣ��", address1.getAddress(), "2017-06-12 08:23:45", 0);
        Orders orders5 = new Orders(ĭĭ, iPhone7�ֻ�, 1, iPhone7�ֻ�.getPrice(), "13023796942", "ĭĭ", address2.getAddress(), "2015-03-04 21:54:23", 1);
        Orders orders6 = new Orders(ĭĭ, ����ʼǱ�, 1, ����ʼǱ�.getPrice(), "13023796942", "ĭĭ", address2.getAddress(), "2015-05-12 21:54:23", 1);
        Orders orders7 = new Orders(ĭĭ, ����, 2, ����.getPrice() * 2, "13023796942", "ĭĭ", address2.getAddress(), "2017-06-10 18:37:58", 0);
        Orders orders8 = new Orders(ĭĭ, ����, 20, ����.getPrice() * 20, "13023796942", "ĭĭ", address2.getAddress(), "2017-06-10 18:32:10", 0);

        ordersDao.insert(orders1);
        ordersDao.insert(orders2);
        ordersDao.insert(orders3);
        ordersDao.insert(orders4);
        ordersDao.insert(orders5);
        ordersDao.insert(orders6);
        ordersDao.insert(orders7);
        ordersDao.insert(orders8);

        evaluateDao.insert(new Evaluate(orders1, "����E7���˺ܾ��ˣ������ܺã�������", Evaluate.LEVEL_GOOD, "2016-05-12 09:21:42"));
        evaluateDao.insert(new Evaluate(orders2, "����һ��ɣ���ʱ�ܿ�", Evaluate.LEVEL_NORMAL, "2015-01-12 09:21:42"));
        evaluateDao.insert(new Evaluate(orders5, "ƻ����ISOϵͳһֱ�ܿ죬װ��������", Evaluate.LEVEL_GOOD, "2015-03-07 15:34:12"));
        evaluateDao.insert(new Evaluate(orders6, "ʲô�Ƶ��ԣ�����û����ͻ���", Evaluate.LEVEL_BAD, "2015-05-22 15:34:12"));

        goodsImageDao.insert(new GoodsImage(����ʼǱ�, "admin/img/goods_1.jpg"));
        goodsImageDao.insert(new GoodsImage(����ʼǱ�, "admin/img/goods_2.jpg"));
        goodsImageDao.insert(new GoodsImage(����ʼǱ�, "admin/img/goods_3.jpg"));
        goodsImageDao.insert(new GoodsImage(����ʼǱ�, "admin/img/goods_4.jpg"));
        goodsImageDao.insert(new GoodsImage(����ʼǱ�, "admin/img/goods_5.jpg"));
        goodsImageDao.insert(new GoodsImage(ƻ���ʼǱ�, "admin/img/goods_6.jpg"));
        goodsImageDao.insert(new GoodsImage(ƻ���ʼǱ�, "admin/img/goods_7.jpg"));
        goodsImageDao.insert(new GoodsImage(ƻ���ʼǱ�, "admin/img/goods_8.jpg"));
        goodsImageDao.insert(new GoodsImage(����E7�ֻ�, "admin/img/goods_9.jpg"));
        goodsImageDao.insert(new GoodsImage(����E7�ֻ�, "admin/img/goods_10.jpg"));
        goodsImageDao.insert(new GoodsImage(iPhone7�ֻ�, "admin/img/goods_11.jpg"));
        goodsImageDao.insert(new GoodsImage(iPhone7�ֻ�, "admin/img/goods_12.jpg"));
        goodsImageDao.insert(new GoodsImage(����, "admin/img/goods_13.jpg"));
        goodsImageDao.insert(new GoodsImage(����, "admin/img/goods_14.jpg"));
        goodsImageDao.insert(new GoodsImage(����, "admin/img/goods_15.jpg"));
        goodsImageDao.insert(new GoodsImage(ƻ��, "admin/img/goods_16.jpg"));
        goodsImageDao.insert(new GoodsImage(����, "admin/img/goods_17.jpg"));
        goodsImageDao.insert(new GoodsImage(����, "admin/img/goods_18.jpg"));
        goodsImageDao.insert(new GoodsImage(����, "admin/img/goods_19.jpg"));

        // ��Ӷ��������������
        Shop shop = new Shop(����, "�������̵�", "�������̵������", "admin/img/shop_1.jpg");
        shopDao.insert(shop);
        for (int i = 1; i <= 103; i++) {
            Goods goods = new Goods("��Ʒ" + i, "��Ʒ����" + i,
                    i, goodsTypeDao.queryById(i % 10 + 1), shop, 500 + i * 100);
            goodsDao.insert(goods);
            GoodsImage goodsImage = new GoodsImage(goods, "admin/img/goods_" + (i % 19 + 1) + ".jpg");
            goodsImageDao.insert(goodsImage);
        }

        GsonUtil.printFormatJson(customerDao.query("15521302230", "123"));
        GsonUtil.printFormatJson(goodsImageDao.queryByGoodsId(1));
        GsonUtil.printFormatJson(goodsImageDao.queryByGoodsId(2));
        GsonUtil.printFormatJson(goodsDao.queryByShopId(1, 0, 0));
        GsonUtil.printFormatJson(goodsDao.queryAll());
        GsonUtil.printFormatJson(ordersDao.queryById(1));
        GsonUtil.printFormatJson(addressDao.queryAll());
        GsonUtil.printFormatJson(goodsDao.queryByCustomerId(1, 0, 0));
        GsonUtil.printFormatJson(evaluateDao.queryByGoodsId(1));
        GsonUtil.printFormatJson(goodsDao.queryAll());

    }

    private void dropTableAndCreate() {
        addressDao.dropTable();
        evaluateDao.dropTable();
        shopCarDao.dropTable();
        ordersDao.dropTable();
        goodsImageDao.dropTable();
        goodsDao.dropTable();
        shopDao.dropTable();
        sellerDao.dropTable();
        customerDao.dropTable();
        goodsTypeDao.dropTable();

        goodsTypeDao.createTable();
        customerDao.createTable();
        sellerDao.createTable();
        shopDao.createTable();
        goodsDao.createTable();
        goodsImageDao.createTable();
        ordersDao.createTable();
        shopCarDao.createTable();
        evaluateDao.createTable();
        addressDao.createTable();

        sellerDao.createForeignKey();
        shopDao.createForeignKey();
        goodsDao.createForeignKey();
        goodsImageDao.createForeignKey();
        ordersDao.createForeignKey();
        shopCarDao.createForeignKey();
        evaluateDao.createForeignKey();
        addressDao.createForeignKey();

    }

    @Before
    public void init() {
        goodsTypeDao = DaoFactory.getGoodsTypeDao();
        customerDao = DaoFactory.getCustomerDao();
        sellerDao = DaoFactory.getSellerDao();
        shopDao = DaoFactory.getShopDao();
        goodsDao = DaoFactory.getGoodsDao();
        goodsImageDao = DaoFactory.getGoodsImageDao();
        ordersDao = DaoFactory.getOrdersDao();
        shopCarDao = DaoFactory.getShopCarDao();
        evaluateDao = DaoFactory.getEvaluateDao();
        addressDao = DaoFactory.getAddressDao();
    }

}
