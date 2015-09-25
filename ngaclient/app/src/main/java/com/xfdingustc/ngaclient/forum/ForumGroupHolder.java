package com.xfdingustc.ngaclient.forum;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.SparseArray;

import com.xfdingustc.ngaclient.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xiaofei on 2015/9/25.
 */
public class ForumGroupHolder {
    private List<ForumGroup> mForumGroupList = new ArrayList<>();

    private static ForumGroupHolder mInstance = null;
    private static Context mSharedContext;

    private ForumGroupHolder() {

    }

    public static ForumGroupHolder getHolder() {
        if (mInstance == null) {
            mInstance = new ForumGroupHolder();
            mInstance.loadDefault();
        }

        return mInstance;
    }

    public static void initialize(Context context) {
        mSharedContext = context;
    }


    public List<ForumGroup> getForumGroupList() {
        return mForumGroupList;
    }

    private void loadDefault() {
        int i = 0;

        ForumGroup group1 = new ForumGroup("综合讨论");
        group1.add(new Forum("7", "议事厅", R.drawable.p7));
        group1.add(new Forum("323", "国服以外讨论", R.drawable.p323));
        group1.add(new Forum("10", "银色黎明", R.drawable.p10));
        group1.add(new Forum("230", "艾泽拉斯风纪委员会", R.drawable.p230));
        group1.add(new Forum("387", "潘大力亚之迷雾", R.drawable.p387));
        group1.add(new Forum("430", "德拉诺之王", R.drawable.p430));
        group1.add(new Forum("305", "305权贵区", R.drawable.p305));
        group1.add(new Forum("11", "诺森德埋骨地", R.drawable.p11));
        mForumGroupList.add(group1);


        ForumGroup group2 = new ForumGroup("大漩涡系列");
        group2.add(new Forum("-7", "大漩涡", R.drawable.p354));
        group2.add(new Forum("-343809", "汽车俱乐部", R.drawable.p343809));
        group2.add(new Forum("-81981", "生命之杯", R.drawable.p81981));
        group2.add(new Forum("-576177", "影音讨论区", R.drawable.p576177));
        group2.add(new Forum("-43", "军事历史", R.drawable.p43));
        group2.add(new Forum("414", "游戏综合讨论", R.drawable.p414));
        group2.add(new Forum("415", "主机游戏综合讨论", R.drawable.p415));
        group2.add(new Forum("427", "怪物猎人", R.drawable.p427));
        group2.add(new Forum("431", "风暴英雄", R.drawable.p431));
        group2.add(new Forum("436", "消费电子 IT新闻", R.drawable.p436));
        group2.add(new Forum("340", "无聊图", R.drawable.p340));
        group2.add(new Forum("456", "冲水区", R.drawable.p456));
        group2.add(new Forum("-187579", "大漩涡历史博物馆", R.drawable.p187579));
        mForumGroupList.add(group2);


        ForumGroup group3 = new ForumGroup("职业讨论区");
        group3.add(new Forum("477", "伊利达雷", R.drawable.oldp477));
        group3.add(new Forum("390", "五晨寺", R.drawable.p390));
        group3.add(new Forum("320", "黑锋要塞", R.drawable.p320));
        group3.add(new Forum("181", "铁血沙场", R.drawable.p181));
        group3.add(new Forum("182", "魔法圣堂", R.drawable.p182));
        group3.add(new Forum("183", "信仰神殿", R.drawable.p183));
        group3.add(new Forum("185", "风暴祭坛", R.drawable.p185));
        group3.add(new Forum("186", "翡翠梦境", R.drawable.p186));
        group3.add(new Forum("187", "猎手大厅", R.drawable.p187));
        group3.add(new Forum("184", "圣光之力", R.drawable.p184));
        group3.add(new Forum("188", "恶魔深渊", R.drawable.p188));
        group3.add(new Forum("189", "暗影裂口", R.drawable.p189));
        mForumGroupList.add(group3);




        ForumGroup group4 = new ForumGroup("职业讨论区");
        group4.add(new Forum("310", "精英议会", R.drawable.p310));
        group4.add(new Forum("190", "任务讨论", R.drawable.p190));
        group4.add(new Forum("213", "战争档案", R.drawable.p213));
        group4.add(new Forum("218", "副本专区", R.drawable.p218));
        group4.add(new Forum("258", "战场讨论", R.drawable.p258));
        group4.add(new Forum("272", "竞技场", R.drawable.p272));
        group4.add(new Forum("191", "地精商会", R.drawable.p191));
        group4.add(new Forum("200", "插件研究", R.drawable.p200));
        group4.add(new Forum("240", "BigFoot", R.drawable.p240));
        group4.add(new Forum("460", "大脚综合", R.drawable.p460));
        group4.add(new Forum("461", "大脚水区", R.drawable.p461));
        group4.add(new Forum("458", "大脚LOL", R.drawable.p458));
        group4.add(new Forum("274", "插件发布", R.drawable.p274));
        group4.add(new Forum("315", "战斗统计", R.drawable.p315));
        group4.add(new Forum("333", "DKP系统", R.drawable.p333));
        group4.add(new Forum("327", "成就讨论", R.drawable.p327));
        group4.add(new Forum("388", "幻化讨论", R.drawable.p388));
        group4.add(new Forum("411", "宠物讨论", R.drawable.p411));
        group4.add(new Forum("463", "要塞讨论", R.drawable.p463));
        group4.add(new Forum("255", "公会管理", R.drawable.p255));
        group4.add(new Forum("306", "人员招募", R.drawable.p306));
        mForumGroupList.add(group4);


        ForumGroup group5 = new ForumGroup("麦迪文之塔");
        group5.add(new Forum("264", "卡拉赞剧院", R.drawable.p264));
        group5.add(new Forum("8", "大图书馆", R.drawable.p8));
        group5.add(new Forum("102", "作家协会", R.drawable.p102));
        group5.add(new Forum("124", "壁画洞窟", R.drawable.p124));
        group5.add(new Forum("254", "镶金玫瑰", R.drawable.p254));
        group5.add(new Forum("355", "龟岩兄弟会", R.drawable.p355));
        group5.add(new Forum("116", "奇迹之泉", R.drawable.p116));
        mForumGroupList.add(group5);


        ForumGroup group6 = new ForumGroup("系统软硬件讨论");
        group6.add(new Forum("193", "帐号安全", R.drawable.p193));
        group6.add(new Forum("334", "PC软硬件", R.drawable.p334));
        group6.add(new Forum("201", "系统问题", R.drawable.p201));
        group6.add(new Forum("335", "网站开发", R.drawable.p335));
        mForumGroupList.add(group6);

        ForumGroup group7 = new ForumGroup("其他游戏");
        group7.add(new Forum("414", "游戏综合讨论", R.drawable.p414));
        group7.add(new Forum("428", "手机游戏", R.drawable.p428));
        group7.add(new Forum("431", "风暴英雄", R.drawable.p431));
        group7.add(new Forum("-452227", "口袋妖怪", R.drawable.p452227));
        group7.add(new Forum("426", "智龙迷城", R.drawable.p426));
        group7.add(new Forum("-51095", "部落战争", R.drawable.p51095));
        group7.add(new Forum("-362960", "最终幻想14", R.drawable.p362960));
        group7.add(new Forum("-6194253", "战争雷霆", R.drawable.p6194253));
        group7.add(new Forum("427", "怪物猎人", R.drawable.p427));
        group7.add(new Forum("-47218", "地下城与勇士", R.drawable.p47218));
        group7.add(new Forum("425", "行星边际2", R.drawable.p425));
        group7.add(new Forum("422", "炉石传说", R.drawable.p422));
        group7.add(new Forum("-65653", "剑灵", R.drawable.p65653));
        group7.add(new Forum("412", "巫师之怒", R.drawable.p412));
        group7.add(new Forum("-235147", "激战2", R.drawable.p235147));
        group7.add(new Forum("442", "逆战", R.drawable.p442));
        group7.add(new Forum("-46468", "坦克世界", R.drawable.p46468));
        group7.add(new Forum("432", "战机世界", R.drawable.p432));
        group7.add(new Forum("441", "战舰世界", R.drawable.p441));
        group7.add(new Forum("321", "DotA", R.drawable.p321));
        group7.add(new Forum("375", "DotA联赛饰品", R.drawable.p375));
        group7.add(new Forum("-2371813", "EVE", R.drawable.p2371813));
        group7.add(new Forum("-7861121", "剑叁 ", R.drawable.p7861121));
        group7.add(new Forum("448", "剑叁同人 ", R.drawable.p448));
        group7.add(new Forum("-793427", "斗战神", R.drawable.p793427));
        group7.add(new Forum("332", "战锤40K", R.drawable.p332));
        group7.add(new Forum("416", "火炬之光2", R.drawable.p416));
        group7.add(new Forum("406", "星际争霸2", R.drawable.p406));
        group7.add(new Forum("420", "MT Online", R.drawable.p420));
        group7.add(new Forum("424", "圣斗士星矢", R.drawable.p424));
        group7.add(new Forum("-1513130", "鲜血兄弟会", R.drawable.p1513130));
        group7.add(new Forum("433", "神雕侠侣", R.drawable.p433));
        group7.add(new Forum("434", "神鬼幻想", R.drawable.p434));
        group7.add(new Forum("435", "上古卷轴Online", R.drawable.p435));
        group7.add(new Forum("443", "FIFA Online 3", R.drawable.p443));
        group7.add(new Forum("444", "刀塔传奇", R.drawable.p444));
        group7.add(new Forum("445", "迷你西游", R.drawable.p445));
        group7.add(new Forum("447", "锁链战记", R.drawable.p447));
        group7.add(new Forum("-532408", "沃土", R.drawable.p532408));
        group7.add(new Forum("353", "纽沃斯英雄传", R.drawable.p353));
        group7.add(new Forum("452", "天涯明月刀", R.drawable.p452));
        group7.add(new Forum("453", "魔力宝贝", R.drawable.p453));
        group7.add(new Forum("454", "神之浩劫", R.drawable.p454));
        group7.add(new Forum("455", "鬼武者 魂", R.drawable.p455));
        mForumGroupList.add(group7);

        ForumGroup group8 = new ForumGroup("暗黑破坏神");
        group8.add(new Forum("318", "暗黑破坏神3", R.drawable.p318));
        group8.add(new Forum("403", "购买/安装/共享", R.drawable.p403));
        group8.add(new Forum("393", "背景故事与文艺作品", R.drawable.p393));
        group8.add(new Forum("400", "职业讨论区", R.drawable.p400));
        group8.add(new Forum("395", "野蛮人", R.drawable.p395));
        group8.add(new Forum("396", "猎魔人", R.drawable.p396));
        group8.add(new Forum("397", "武僧", R.drawable.p397));
        group8.add(new Forum("398", "巫医", R.drawable.p398));
        group8.add(new Forum("399", "魔法师", R.drawable.p399));
        group8.add(new Forum("446", "圣教军", R.drawable.p446));
        mForumGroupList.add(group8);

        ForumGroup group9 = new ForumGroup("暴雪游戏");
        group9.add(new Forum("422", "炉石传说", R.drawable.p422));
        group9.add(new Forum("429", "战术讨论", R.drawable.p429));
        group9.add(new Forum("450", "文章存档", R.drawable.p450));
        group9.add(new Forum("431", "风暴英雄", R.drawable.p431));
        group9.add(new Forum("457", "视频资料", R.drawable.p457));
        group9.add(new Forum("459", "守望先锋", R.drawable.p459));
        mForumGroupList.add(group9);

        ForumGroup group10 = new ForumGroup("英雄联盟");
        group10.add(new Forum("-152678", "英雄联盟", R.drawable.p152678));
        group10.add(new Forum("418", "游戏视频", R.drawable.p418));
        mForumGroupList.add(group10);

        ForumGroup group11 = new ForumGroup("个人版面");
        group11.add(new Forum("-447601", "二次元国家地理", R.drawable.p447601));
        group11.add(new Forum("-84", "模玩之魂", R.drawable.p84));
        group11.add(new Forum("-8725919", "小窗视界", R.drawable.p8725919));
        group11.add(new Forum("-965240", "树洞", R.drawable.p965240));
        group11.add(new Forum("-131429", "红茶馆——小说馆", R.drawable.p131429));
        group11.add(new Forum("-608808", "血腥厨房", R.drawable.p608808));
        group11.add(new Forum("-469608", "影~视~秀", R.drawable.p469608));
        group11.add(new Forum("-55912", "音乐讨论", R.drawable.p55912));
        group11.add(new Forum("-522474", "综合体育讨论区", R.drawable.p522474));
        group11.add(new Forum("-1068355", "晴风村", R.drawable.p1068355));
        group11.add(new Forum("-168888", "育儿版", R.drawable.p168888));
        group11.add(new Forum("-54214", "时尚板", R.drawable.p54214));
        group11.add(new Forum("-353371", "宠物养成", R.drawable.p353371));
        group11.add(new Forum("-538800", "乙女向二次元", R.drawable.p538800));
        group11.add(new Forum("-7678526", "麻将科学院", R.drawable.p7678526));
        group11.add(new Forum("-202020", "程序员职业交流", R.drawable.p202020));
        group11.add(new Forum("-444012", "我们的骑迹", R.drawable.p444012));
        group11.add(new Forum("-349066", "开心茶园", R.drawable.p349066));
        group11.add(new Forum("-314508", "世界尽头的百货公司", R.drawable.p314508));
        group11.add(new Forum("-2671", "耳机区", R.drawable.p2671));
        group11.add(new Forum("-970841", "东方教主陈乔恩", R.drawable.p970841));
        group11.add(new Forum("-3355501", "基腐版", R.drawable.p3355501));
        group11.add(new Forum("-403298", "怨灵图纸收藏室", R.drawable.p403298));
        group11.add(new Forum("-3432136", "飘落的诗章", R.drawable.p3432136));
        group11.add(new Forum("-187628", "家居 装修", R.drawable.p187628));
        group11.add(new Forum("-8627585", "牛头人酋长乐队", R.drawable.p8627585));
        mForumGroupList.add(group11);

    }
}
