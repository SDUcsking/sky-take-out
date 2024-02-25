package com.sky.controller.admin;

import com.sky.dto.SetmealDTO;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.mapper.SetmealMapper;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.SetmealService;
import com.sky.vo.SetmealVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ClassName: SetmealService
 * Package: com.sky.controller.admin
 * Description:
 *
 * @Author han
 * @Create 2024/2/24  8:40
 * Version 1.0
 */
@RestController
@RequestMapping("/admin/setmeal")
@Slf4j
@Api("套餐相关操作")
public class SetmealController {
    @Autowired
    SetmealService setmealService;
    @PostMapping
    @ApiOperation("新增套餐")
    public Result save(@RequestBody SetmealDTO setmealDTO){
        log.info("新增套餐,{}",setmealDTO);
        setmealService.save(setmealDTO);
        return Result.success();
    }


    @GetMapping("page")
    @ApiOperation("分页查询")
    public Result<PageResult>pageQuery(SetmealPageQueryDTO setmealPageQueryDTO){
        log.info("分页查询,{}",setmealPageQueryDTO);
        PageResult pageResult= setmealService.pageQuery(setmealPageQueryDTO);
        return Result.success(pageResult);
    }
    @DeleteMapping()
    @ApiOperation("批量删除套餐")
    public Result deleteBatch(@RequestParam List<Long>ids){//接受param码中的多值参数使用@RequestParam如list,映射所有参数map
        log.info("批量删除,{}",ids);
        setmealService.deleteBatch(ids);
        return Result.success();
    }
    @GetMapping("/{id}")
    @ApiOperation("根据 id查询套餐")
    public Result<SetmealVO> getById(@PathVariable Long id){
        log.info("根据id查询套餐,{}",id);
        SetmealVO setmealVO=setmealService.getById(id);
        return Result.success(setmealVO);
    }
    @PutMapping
    @ApiOperation("修改套餐")
    public Result update(@RequestBody SetmealDTO setmealDTO){
        log.info("修改套餐,{}",setmealDTO);
        setmealService.update(setmealDTO);
        return Result.success();
    }
    @PostMapping("status/{status}")
    @ApiOperation("套餐起售停售")
    public Result startOrStop(@PathVariable Integer status,Long id){
        setmealService.startOrStop(status,id);
        return Result.success();

    }

}
