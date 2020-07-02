//package com.fox.scala;
//
//import java.text.SimpleDateFormat
//import java.util.Date
//
//var now:Date = new Date()
//        val dateFormatDay = new SimpleDateFormat("yyyyMMdd")
//        val dateFormatSecond = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
//        val dateFormatHour = new SimpleDateFormat("HH")
////当前日期20190417
//        val currentDayStr=dateFormatDay.format(now)
////获取当日零点的时间值
//        val lowerBound=dateFormatDay.parse(dateFormatDay.format(now)).getTime/1000.toInt
////获取当前定时任务的时间值
//        val upperBound = dateFormatSecond.parse(dateFormatSecond.format(now)).getTime/1000.toInt
////获取当前任务的时间整点值
//        val hourValue=dateFormatHour.format(now)
//
////  全部
//        val esQueryAll = s"""
//        {
//        "query": {
//        "bool": {
//        "must": [
//        {
//        "term": {
//        "is_deleted": 0
//        }
//        },
//        {
//        "terms": {
//        "source": [
//        0,
//        99
//        ]
//        }
//        },
//        {
//        "range": {
//        "delivery_date": {
//        "from": $lowerBound,
//        "to": $upperBound,
//        "include_lower": true,
//        "include_upper": true
//        }
//        }
//        },
//
//        {
//        "range": {
//        "sort_weight": {
//        "lt": 0.01
//        }
//        }
//        },
//        {
//        "range": {
//        "lack_weight": {
//        "gte": 0.01
//        }
//        }
//        },
//        {
//        "range": {
//        "order_item_status": {
//        "gte": 230
//        }
//        }
//        }
//        ],
//        "must_not" : [
//        {
//        "term": {
//        "is_replenished": 1
//        }
//        },
//        {
//        "term": {
//        "source": 11
//        }
//        },
//        {
//        "term": {
//        "deliveryMode": 1
//        }
//        }
//        ]
//        }
//        }
//        }
//        """
//
////  查询当天wms_data_center.t_site_sorting_lack_record的所有OI集合
//        val esQueryWms = s"""
//        {
//        "query": {
//        "bool": {
//        "must": [
//        {
//        "term": {
//        "is_deleted": 0
//        }
//        },
//        {
//        "range": {
//        "delivery_date": {
//        "from": $lowerBound,
//        "to": $lowerBound,
//        "include_lower": true,
//        "include_upper": true
//        }
//        }
//        }
//        ]
//        }
//        }
//        }
//        """
//
//        sqlRunner.readFromEs("oms_data_center2/s_order_item_lack", esQueryAll).createOrReplaceTempView("soiALL");
//
//        sqlRunner.readFromEs("wms_data_center/t_site_sorting_lack_record", esQueryWms).createOrReplaceTempView("wmsALL");
//
////去重wmsALL
//        sql(s"""
//        SELECT
//        distinct oi_id
//        FROM wmsALL
//        """).createOrReplaceTempView("wmsViewALL");
//
////左连接拼接所需数据
//        sql(s"""
//        SELECT
//        soi.city_id as city_id
//        , soi.city_name as city_name
//        , soi.warehouse_id as warehouse_id
//        , soi.warehouse_name as warehouse_name
//        , soi.sku_id as sku_id
//        , soi.company_id as company_id
//        , soi.omc_order_id as omc_order_id
//        ,wms.oi_id as oi_id
//        FROM soiALL soi left join wmsViewALL  wms on soi.omc_order_item_id=wms.oi_id
//        """).createOrReplaceTempView("soiLastAll");
//
//        var ret = sql(s"""
//        SELECT
//        CONCAT(city_id, "-", warehouse_id, "-", $currentDayStr,"-",$hourValue ) as union_key
//        ,$currentDayStr as datekey
//        ,$hourValue as hourValue
//        ,city_id as cityId
//        ,collect_set(city_name)[0] as cityName
//        , warehouse_id as globalWarehouseId
//        ,collect_set(warehouse_name)[0] as warehouseName
//        ,count(DISTINCT(sku_id)) AS outStockSkuNumber
//        ,count(sku_id) AS skuNumber
//        ,count(DISTINCT(company_id)) AS influenceMerchant
//        ,count(DISTINCT(omc_order_id)) AS outStockOrderNumber
//        ,sum(case when  isnull(oi_id) then 1 else 0 end  ) AS mainStoreOutOfStock
//        ,sum(case when  isnull(oi_id) then 0 else 1 end )  AS siteOutOfStock
//        FROM soiLastAll
//        GROUP BY city_id,warehouse_id
//        """)
