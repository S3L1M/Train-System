package report;

/**
 *
 * @author Mina
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.TextAnchor;

public class BarChart extends ApplicationFrame {

    static String chartTitle ="";

    public BarChart(String title, String[] names, double[] values) {

        super(title);
        this.chartTitle = title;
        //by7ot asm el header el wa5do ely howa line report 
        final CategoryDataset dataset = createDataset(names, values);
        //hena byb3t al two arrayes le function 3ashn tee create el dataset 
        final JFreeChart chart = createChart(dataset);
        //hena byb3t el dataset ely at3mlt le function createchart 3ashn tersm
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(900, 650));
        //byde el two Dimension le el ChartPanel
        setContentPane(chartPanel);

        try {

            saveToFile(chart, 900, 650, 100);
            //save in file with width and higeth
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void saveToFile(JFreeChart chart, int width, int height, double quality)throws FileNotFoundException, IOException {
        BufferedImage img = draw(chart, width, height);
        //bydeha el width we height we el rasma nafsha
        File outputfile = new File(System.getProperty("user.dir") + "/" + chartTitle + "_savedChart.png");
        ImageIO.write(img, "png", outputfile);
    }
    protected static BufferedImage draw(JFreeChart chart, int width, int height) {
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = img.createGraphics();

        chart.draw(g2, new Rectangle2D.Double(0, 0, width, height));

        g2.dispose();
        return img;
    }
    
    private CategoryDataset createDataset(String[] names, double[] values) {
        
        final String series1 = "Line Report";
        //Deh awl asm le el row repoert 
        final String series2="The best Line";
       //Deh tany asm le el row repoert 
      
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    //hena bta5od el dataset we bt5leha 2D Graphics 3ashn  ttb3t le createchart 
        int f = 0;
        //use it to compare
        for (int i = 0; i < names.length; i++) {
            dataset.addValue(values[i], series1, names[i]);
             //bdef value fe e data set mkona mn el name we el value
           if (values[f]<values[i])
                {
                f=i;
                }
           /*compare to find the best line*/
        }
    dataset.addValue(values[f], series2, names[f]);
   //bdef value fe e data set mkona mn el name we el value
        return dataset;
        //bnrg3 el dataset ely hattrsm
    }
    private JFreeChart createChart(final CategoryDataset dataset) {

        // create the chart
        final JFreeChart chart = ChartFactory.createBarChart(chartTitle, // chart
                // title
                "Line", // domain axis label
                "Passenger", // range axis label
                dataset, // data
                PlotOrientation.VERTICAL, //orientation
                true, // include legend
                true, // tooltips
                false // URLs
        );

        chart.setBackgroundPaint(Color.white);//Ba7ot background color lel frame
        
        final CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(Color.WHITE);
        //background llel rasma
        plot.setDomainGridlinePaint(Color.white);
        //color ely byt7t feh el ha3mel 3lehom el 7aga
        plot.setRangeGridlinePaint(Color.BLUE);
        //color el 5at ely mbyen el no2t

        plot.getRenderer().setSeriesPaint(0, Color.ORANGE);
        //by3mel color el 0 series
        plot.getRenderer().setSeriesPaint(1, Color.BLUE);
        //by3ml color el 1 series
      
        
        // set the range axis to display integers only...
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        rangeAxis.setUpperMargin(.9);

        // disable bar outlines...
        final CategoryItemRenderer renderer = plot.getRenderer();
        renderer.setSeriesItemLabelsVisible(0, Boolean.TRUE);

        final CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);

        Font f = new Font("TimesRoman", Font.ITALIC, 20);
        Font f1 = new Font("TimesRoman", Font.LAYOUT_LEFT_TO_RIGHT, 12);
        //by3ml el font 
        
        domainAxis.setLabelFont(f);
        domainAxis.setTickLabelFont(f1);

        rangeAxis.setLabelFont(f);

        renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        renderer.setBaseItemLabelsVisible(true);
        ItemLabelPosition position = new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12,
                TextAnchor.HALF_ASCENT_CENTER);
        renderer.setBasePositiveItemLabelPosition(position);
        return chart;
    }
}
