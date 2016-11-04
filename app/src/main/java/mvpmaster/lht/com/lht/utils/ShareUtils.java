package mvpmaster.lht.com.lht.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/**
 * Created by Ly on 2016/11/4.
 */

public class ShareUtils {
    /**
     * 分享功能
     *
     * @param context       上下文
     * @param activityTitle Activity的名字
     * @param msgTitle      消息标题
     * @param msgText       消息内容
     * @param imgPath       图片路径，不分享图片则传null
     */
    public static void shareMsg(Context context, String activityTitle, String msgTitle, String msgText,
                                int imgPath, boolean ShareImg) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        if (!ShareImg) {
            intent.setType("text/plain"); // 纯文本
        } else {
            try {
                intent.setType("image/jpg");
                intent.putExtra(Intent.EXTRA_STREAM, getUrlFromDrawable(context, imgPath));
            } catch (Exception e) {
                intent.setType("text/plain"); // 纯文本
            }
        }
        intent.putExtra(Intent.EXTRA_SUBJECT, msgTitle);
        intent.putExtra(Intent.EXTRA_TEXT, msgText);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(Intent.createChooser(intent, activityTitle));
    }


    private static Uri getUrlFromDrawable(Context context, int drawRes) {
        Uri uri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://"
                + context.getResources().getResourcePackageName(drawRes) + "/"
                + context.getResources().getResourceTypeName(drawRes) + "/"
                + context.getResources().getResourceEntryName(drawRes));
        return uri;

    }
}
