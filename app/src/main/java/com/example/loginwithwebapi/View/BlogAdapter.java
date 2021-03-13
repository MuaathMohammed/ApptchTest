package com.example.loginwithwebapi.View;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginwithwebapi.Models.Blogs;
import com.example.loginwithwebapi.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BlogAdapter extends RecyclerView.Adapter<BlogAdapter.ViewHolder> {
private ArrayList<Blogs> BlogData;
private Context _context;

    public BlogAdapter(ArrayList<Blogs> blogData, Context _context) {
        BlogData = blogData;
        this._context = _context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_content, parent, false);
        final ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Blogs bd=BlogData.get(position);
        holder.BTitle.setText(bd.getBlogTitle());
        holder.BCreator.setText(bd.getBlogCreator());
        holder.BDescription.setText(bd.getBlogDescription());
        Picasso.get().load(bd.getBlogImage()).into(holder.BImg);
         holder.BtExToExel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    createExcelSheet(bd.getBlogTitle(),bd.getBlogCreator(),bd.getBlogDescription());
                } catch (WriteException e) {
                    e.printStackTrace();
                }

            }
        });

    }
  private void createExcelSheet(String Title,String Creator,String Description) throws WriteException {
        WritableCellFormat arial14format = null;
        WritableFont arial14font = null;
        arial14font = new WritableFont(WritableFont.ARIAL, 14, WritableFont.BOLD);
        arial14font.setColour(jxl.format.Colour.LIGHT_BLUE);
        arial14format = new WritableCellFormat(arial14font);
        arial14format.setAlignment(jxl.format.Alignment.CENTRE);
        arial14format.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
        arial14format.setBackground(jxl.format.Colour.VERY_LIGHT_YELLOW);
        String Fnamexls="Excel_"+System.currentTimeMillis()+ ".xls";
        File sdCard = Environment.getExternalStorageDirectory();
        File directory = new File (sdCard.getAbsolutePath()+"/mm");
        directory.mkdir();
        File file = new File(directory, Fnamexls);

        WorkbookSettings wbSettings = new WorkbookSettings();

        wbSettings.setLocale(new Locale("ar", "Ar"));

        WritableWorkbook workbook;
        try {
            int a = 1;
            workbook = Workbook.createWorkbook(file, wbSettings);
            //workbook.createSheet("Report", 0);
            WritableSheet sheet = workbook.createSheet("تصدير الى اكسل", 0);
            Label label = new Label(0, 2, Title,arial14format);
            Label label1 = new Label(0,1,Creator);
            Label label0 = new Label(0,0,Description,arial14format);
            Label label3 = new Label(1,0,Description,arial14format);

            try {
                sheet.addCell(label);
                sheet.addCell(label1);
                sheet.addCell(label0);
                sheet.addCell(label3);
                Log.v(TAG,"تم تصدير البيانات بنجاح");
                // Toast.makeText(_context,"تم تصدير ملف الاكسل",Toast.LENGTH_SHORT);
            } catch (RowsExceededException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (WriteException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            workbook.write();
            try {
                workbook.close();
            } catch (WriteException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            //createExcel(excelSheet);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    @Override
    public int getItemCount() {
        return BlogData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView BImg;
        TextView BTitle,BDescription,BCreator;
 Button BtExToExel;

    public ViewHolder(@NonNull View itemView) {

        super(itemView);
        BImg=itemView.findViewById(R.id.image_view_news);
        BTitle=itemView.findViewById(R.id.News_Title);
        BCreator=itemView.findViewById(R.id.BlogCreator);
        BDescription=itemView.findViewById(R.id.News_Desc);
        BtExToExel=itemView.findViewById(R.id.btExToExcel);



    }
}
}
