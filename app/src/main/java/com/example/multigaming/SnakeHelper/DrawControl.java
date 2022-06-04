package com.example.multigaming.SnakeHelper;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;

import com.example.multigaming.AppConstants;

public class DrawControl {


    public void drawControl(Canvas m_Canvas, AppConstants.Control m_Control, Paint m_Paint, int m_ScreenWidth, int m_ScreenHeight, int m_BlockSize, AppConstants.Direction m_Direction)
    {
        int x = m_ScreenWidth/4;
        int y = m_ScreenHeight/2;

        int width = m_BlockSize*4;

            if(m_Direction ==  com.example.multigaming.AppConstants.Direction.LEFT || m_Direction == com.example.multigaming.AppConstants.Direction.RIGHT)
            {
                drawTriangleUp(m_Canvas,m_Paint,x,y,width);
                drawTriangleDown(m_Canvas,m_Paint,x*3,y,width);
            }
            else
            {
                drawTriangleLeft(m_Canvas,m_Paint,x,y,width);
                drawTriangleRight(m_Canvas,m_Paint,x*3,y,width);
            }



    }


    //<editor-fold desc="Triangle Drawing">
    private void drawTriangleUp(Canvas canvas, Paint m_Paint, int x, int y, int width) {
        int halfWidth = width / 2;

        m_Paint.setColor(Color.argb(125,  0 , 0, 255));
        Path path = new Path();
        path.moveTo(x, y - halfWidth);
        path.lineTo(x - halfWidth, y + halfWidth);
        path.lineTo(x + halfWidth, y + halfWidth);
        path.lineTo(x, y - halfWidth);
        path.close();
        canvas.drawPath(path, m_Paint);
    }
    private void drawTriangleDown(Canvas canvas, Paint m_Paint, int x, int y, int width) {
        int halfWidth = width / 2;

        m_Paint.setColor(Color.argb(125,  0 , 0, 255));
        Path path = new Path();
        path.moveTo(x, y + halfWidth);
        path.lineTo(x - halfWidth, y - halfWidth);
        path.lineTo(x + halfWidth, y - halfWidth);
        path.lineTo(x, y + halfWidth);
        path.close();
        canvas.drawPath(path, m_Paint);
    }
    private void drawTriangleLeft(Canvas canvas, Paint m_Paint, int x, int y, int width) {
        int halfWidth = width / 2;

        m_Paint.setColor(Color.argb(125,  0 , 0, 255));
        Path path = new Path();
        path.moveTo(x - halfWidth, y);
        path.lineTo(x + halfWidth, y + halfWidth);
        path.lineTo(x + halfWidth, y - halfWidth);
        path.lineTo(x - halfWidth, y);
        path.close();
        canvas.drawPath(path, m_Paint);
    }
    private void drawTriangleRight(Canvas canvas, Paint m_Paint, int x, int y, int width) {
        int halfWidth = width / 2;

        m_Paint.setColor(Color.argb(125,  0 , 0, 255));
        Path path = new Path();
        path.moveTo(x + halfWidth, y );
        path.lineTo(x - halfWidth, y + halfWidth);
        path.lineTo(x - halfWidth, y - halfWidth);
        path.lineTo(x + halfWidth, y);
        path.close();
        canvas.drawPath(path, m_Paint);
    }
}
