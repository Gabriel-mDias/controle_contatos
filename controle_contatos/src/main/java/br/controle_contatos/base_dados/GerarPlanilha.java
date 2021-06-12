/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controle_contatos.base_dados;

import br.controle_contatos.models.Cliente;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.commons.codec.DecoderException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row; 
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;  
import org.apache.poi.xssf.usermodel.XSSFCellStyle;

/**
 * Código, razão social, telefone de contato (do Excel), nome do cliente
 *
 * @author NOTE_190
 */
public class GerarPlanilha {

    private static final String fileName = "C:\\Users\\NOTE_190\\OneDrive\\Documentos\\xlsx\\planilhaMarcelin\\Clientes.xlsx";

    public void gerarPlanilha(ArrayList<Cliente> clientes, ArrayList<String> municipios) throws DecoderException {

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheetClientes = workbook.createSheet("Clientes");
        
        //fonte dos dados
        Font fonteGeral = workbook.createFont();
        fonteGeral.setFontHeightInPoints((short)11);  
        fonteGeral.setFontName("Calibri");   
        
        //estilo dos dados
        CellStyle styleDados = workbook.createCellStyle();
        styleDados.setFont(fonteGeral);
        styleDados.setBorderBottom(XSSFCellStyle.BORDER_MEDIUM);
        styleDados.setBorderLeft(XSSFCellStyle.BORDER_MEDIUM);
        styleDados.setBorderTop(XSSFCellStyle.BORDER_MEDIUM);
        styleDados.setBorderRight(XSSFCellStyle.BORDER_MEDIUM);
        
                
        //fonte do titulo da cidade
        Font fontTituloCidade = workbook.createFont();  
        fontTituloCidade.setFontHeightInPoints((short)23);  
        fontTituloCidade.setFontName("Calibri");  
            
        //estilo do titulo da cidade
        CellStyle styleTituloCidade = workbook.createCellStyle(); 
        styleTituloCidade.setFillBackgroundColor(IndexedColors.PALE_BLUE.getIndex());
        styleTituloCidade.setFillForegroundColor(IndexedColors.PALE_BLUE.getIndex()); 
        styleTituloCidade.setFont(fontTituloCidade);
        styleTituloCidade.setAlignment(CellStyle.ALIGN_CENTER);
        styleTituloCidade.setBorderBottom(XSSFCellStyle.BORDER_MEDIUM);
        styleTituloCidade.setBorderLeft(XSSFCellStyle.BORDER_MEDIUM);
        styleTituloCidade.setBorderTop(XSSFCellStyle.BORDER_MEDIUM);
        styleTituloCidade.setBorderRight(XSSFCellStyle.BORDER_MEDIUM);
        
        //fonte do titulo das colunas
        Font fontTituloColuna = workbook.createFont();
        fontTituloColuna.setFontHeightInPoints((short)11);
        fontTituloColuna.setFontName("Calibri");
        fontTituloColuna.setBold(true);
        
        //estido do titulo das colunas
        CellStyle styleTituloColuna = workbook.createCellStyle();
        styleTituloColuna.setAlignment(CellStyle.ALIGN_CENTER);
        styleTituloColuna.setFont(fontTituloColuna);
        styleTituloColuna.setBorderBottom(XSSFCellStyle.BORDER_MEDIUM);
        styleTituloColuna.setBorderLeft(XSSFCellStyle.BORDER_MEDIUM);
        styleTituloColuna.setBorderTop(XSSFCellStyle.BORDER_MEDIUM);
        styleTituloColuna.setBorderRight(XSSFCellStyle.BORDER_MEDIUM);
        
        int rownum = 0;
        for (int i = 0; i < municipios.size(); i++) {

            Row rowMunicipio = sheetClientes.createRow(rownum++);
            rowMunicipio.setHeightInPoints(40);
            //unindo as celulas para o titulo ocupar o espaço de todas
            CellRangeAddress cra = new CellRangeAddress(rownum-1, rownum-1, 0, 3);
            sheetClientes.addMergedRegion(cra);
        
           
            
            int cellnumX = 0;
            Cell cellMunicipio = rowMunicipio.createCell(cellnumX++);
            cellMunicipio.setCellStyle(styleTituloCidade);
            cellMunicipio.setCellValue(municipios.get(i));
            
            Row rowCabeçalho = sheetClientes.createRow(rownum++);
            rowCabeçalho.setHeightInPoints(17);
            
            int cellnum = 0;
            Cell cellCodigo = rowCabeçalho.createCell(cellnum++);
            cellCodigo.setCellValue("CÓDIGO");
            cellCodigo.setCellStyle(styleTituloColuna);
         
            
            Cell cellRazaoSocial = rowCabeçalho.createCell(cellnum++);
            cellRazaoSocial.setCellValue("RAZÃO SOCIAL");
            cellRazaoSocial.setCellStyle(styleTituloColuna);
            
            Cell cellTelefone = rowCabeçalho.createCell(cellnum++);
            cellTelefone.setCellValue("TELEFONE");
            cellTelefone.setCellStyle(styleTituloColuna);
            
            Cell cellContato = rowCabeçalho.createCell(cellnum++);
            cellContato.setCellValue("CONTATO");
            cellContato.setCellStyle(styleTituloColuna);
            
            for (Cliente c : clientes) {

                if (c.getEndereco().getMunicipio().equals(municipios.get(i))) {

                    Row rowDados = sheetClientes.createRow(rownum++);
                    rowDados.setHeightInPoints(17);
                    int cellnumY = 0;

                    Cell cellCod = rowDados.createCell(cellnumY++);
                    cellCod.setCellValue(c.getCodigo());
                    cellCod.setCellStyle(styleDados);
                    
                    Cell cellRazSocial = rowDados.createCell(cellnumY++);
                    cellRazSocial.setCellValue(c.getRazaoSocial());
                    cellRazSocial.setCellStyle(styleDados);
                    
                    Cell cellTel = rowDados.createCell(cellnumY++);
                    cellTel.setCellValue(c.getTelefone());
                    cellTel.setCellStyle(styleDados);
                    
                    Cell cellCont = rowDados.createCell(cellnumY++);
                    cellCont.setCellValue(c.getContato());
                    cellCont.setCellStyle(styleDados);
                    
                }//if
            }//for clientes
        }//for municipios
        sheetClientes.autoSizeColumn(0);
        sheetClientes.autoSizeColumn(1);
        sheetClientes.autoSizeColumn(2);
        sheetClientes.autoSizeColumn(3);
        sheetClientes.autoSizeColumn(4);
        
        try {
            FileOutputStream out = new FileOutputStream(new File(GerarPlanilha.fileName));
            workbook.write(out);
            out.close();
            System.out.println("Arquivo Excel criado com sucesso!");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Arquivo não encontrado!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro na edição do arquivo!");
        }

    }

}
