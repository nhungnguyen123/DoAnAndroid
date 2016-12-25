package com.uiapp.doan.main.signupstaff.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.AppCompatSpinner;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.google.gson.Gson;
import com.kaopiz.kprogresshud.KProgressHUD;
import com.uiapp.doan.MainActivity;
import com.uiapp.doan.MainApplication;
import com.uiapp.doan.R;
import com.uiapp.doan.base.fragment.BaseFragment;
import com.uiapp.doan.dto.DiaChi;
import com.uiapp.doan.dto.Tho;
import com.uiapp.doan.interactor.api.response.CreateThoResponse;
import com.uiapp.doan.interactor.api.response.DichVuResponse;
import com.uiapp.doan.main.signupstaff.injection.DaggerSignUpStaffComponent;
import com.uiapp.doan.main.signupstaff.injection.SignUpStaffComponent;
import com.uiapp.doan.main.signupstaff.injection.SignUpStaffModule;
import com.uiapp.doan.main.signupstaff.presenter.SignUpStaffPresenter;
import com.uiapp.doan.main.welcom.WelcomeActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;

import static com.uiapp.doan.utils.CommonUtils.showSnackBar;

/**
 * Created by hongnhung on 11/3/16.
 */

public class SignUpStaffFragment extends BaseFragment implements ISignUpStaffView {


    private KProgressHUD mHubAddFood;

    public void showProgress() {
        mHubAddFood = KProgressHUD.create(getContext())
                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE);
        mHubAddFood.show();
    }

    @Bind(R.id.edt_name)
    EditText mEdtName;


    @Bind(R.id.edt_cmnd)
    EditText mEdtCmnd;


    @Bind(R.id.edt_gioitinh)
    EditText mEdtGioiTinh;

    @Bind(R.id.edt_quequan)
    EditText mEdtQueQuan;

    @Bind(R.id.edt_diachihientai)
    EditText mEdtDiaChiHienTai;


    @Bind(R.id.edt_nam_kinh_nghiem)
    EditText mEdtNamKinhNghiem;

    @Bind(R.id.edt_sodt)
    EditText mEdtSdt;

    @Bind(R.id.edt_email)
    EditText mEdtEmail;


    @Bind(R.id.edt_motakinhnghiem)
    EditText mEdtMotaKinhNghiem;

    @Bind(R.id.edt_ngaysinh)
    EditText mEdtNgaySinh;


    @Bind(R.id.edt_tenkhuvuc)
    EditText mEdtTenKhuvuc;

    @Bind(R.id.edt_quan)
    EditText mEdtquan;


    @Bind(R.id.spn_choose_dich_vu_staff)
    AppCompatSpinner mSpDichVu;

    public ArrayAdapter<String> dichvuAdapter;


    @Bind(R.id.btn_sign_up_staff)
    Button mBtnSignUpStaff;


    String name, diachi, quequan, quan, khuvuc, sotruong, ngaysinh, namkinhnghiem, email, sdt, diachihientai, motakinhnghiem;

    public boolean nameOk, diachiOk, quanOk, khuvucOk, sotruongOk, ngaysinhOk, quequanOk, namkinhnghiemOk, emailOk, sdtOk, cmndOk;
    @Inject
    SignUpStaffPresenter mPresenter;


    public static SignUpStaffFragment newInstance() {

        Bundle args = new Bundle();

        SignUpStaffFragment fragment = new SignUpStaffFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SignUpStaffComponent component = DaggerSignUpStaffComponent.builder()
                .applicationComponent(MainApplication.getApplicationComponent(getActivity()))
                .signUpStaffModule(new SignUpStaffModule())
                .build();
        component.inject(this);
        mPresenter.attachView(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_sign_up_staff;
    }

    @Override
    protected void initData() {

        mPresenter.getAllDichVu();
        showProgress();
        dichvuAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, mPresenter.listdichvu);
        dichvuAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpDichVu.setAdapter(dichvuAdapter);

        mSpDichVu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                sotruong = item;

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        mBtnSignUpStaff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("click", "signupstaf");
                nameOk = checkName();

                diachiOk = checkcDiaChi();
                quanOk = checkQuan();
                khuvucOk = checkKhuVuc();
                sotruongOk = checkSotruong();
                ngaysinhOk = checkNgaySinh();
                quequanOk = checkQueQuan();
                namkinhnghiemOk = checkNamKinhNghiem();
                emailOk = checkEmail();
                cmndOk = checkCmnd();
                sdtOk = checkSdt();
                if (nameOk && diachiOk && quequanOk && quanOk && khuvucOk && sotruongOk && ngaysinhOk
                        && namkinhnghiemOk && emailOk && sdtOk && diachiOk && cmndOk) {
//                    mHubAddFood.dismiss();
                    name = mEdtName.getText().toString();
                    diachi = mEdtDiaChiHienTai.getText().toString();
                    quequan = mEdtQueQuan.getText().toString();
                    quan = mEdtquan.getText().toString();
                    khuvuc = mEdtTenKhuvuc.getText().toString();
                    ngaysinh = mEdtNgaySinh.getText().toString();
//                    sotruong = mEdtSoTruong.getText().toString();
                    namkinhnghiem = mEdtNamKinhNghiem.getText().toString();
                    motakinhnghiem = mEdtMotaKinhNghiem.getText().toString();
                    email = mEdtEmail.getText().toString();
                    sdt = mEdtSdt.getText().toString();
                    Tho tho = new Tho();
                    tho.setCmnd(mEdtCmnd.getText().toString() + "");


                    tho.setNgaysinh(ngaysinh);
                    tho.setHoten(name);
                    DiaChi diaChi = new DiaChi();
                    diaChi.setQuan(quan);
                    diaChi.setTenkhuvuc(khuvuc);
                    tho.setDiachi(diaChi);
                    tho.setEmail(email);
                    tho.setSodt(sdt);
                    List<String> listsotruong = new ArrayList<String>();
                    listsotruong.add(sotruong);
                    tho.setSotruong(listsotruong);
                    tho.setMotakinhnghiem(namkinhnghiem);
                    tho.setXacnhan(false);
                    mPresenter.signUpStaff(tho);
                } else {
                    showSnackBar(getView(), "Kiểm tra thông tin lần nữa, please !", Snackbar.LENGTH_SHORT);
//                    mHubAddFood.dismiss();
                }

            }
        });


    }


    @Override
    protected void initListener() {

    }


    @Override
    public void createSuccess(CreateThoResponse createThoResponse) {
        String jsoncreate = new Gson().toJson(createThoResponse);
        Log.e("jsoncreateTho", jsoncreate);
        showSnackBar(getView(), "Bạn đã đăng ký thành công . Chúng tôi sẽ sớm liên lạc lại với bạn qua email của bạn !", Snackbar.LENGTH_LONG);

        Intent intent = new Intent(this.getActivity(), WelcomeActivity.class);
        getActivity().finish();
        startActivity(intent);


    }

    @Override
    public void createError(String message) {
        showSnackBar(getView(), "Đăng ký không thành công, cmnd đã được dùng vui lòng thử lại.!" + message, Snackbar.LENGTH_SHORT);
        Log.e("jsonerrortho", message + "");
    }

    @Override
    public void getDichVuSuccess(DichVuResponse dichVuResponse) {
        dichvuAdapter.notifyDataSetChanged();
        mHubAddFood.dismiss();
    }

    @Override
    public void getDichVuError(String message) {
        mHubAddFood.dismiss();
        showSnackBar(getView(), " Không thể lấy được dịch vụ để bạn đăng ký !" + message, Snackbar.LENGTH_SHORT);
    }


    private boolean checkNamKinhNghiem() {
        String namKinhNghiem = mEdtNamKinhNghiem.getText().toString().trim();
        if (namKinhNghiem.isEmpty() || namKinhNghiem.equals("")) {
            mEdtNamKinhNghiem.setError("Năm kinh nghiệm không thể trống");
            return false;
        }
        return true;
    }

    private boolean checkCmnd() {
        String cmnd = mEdtCmnd.getText().toString().trim();
        if (cmnd.isEmpty() || cmnd.equals("")) {
            mEdtCmnd.setError("Chứng minh nhân dân không thể trống");
            return false;
        }
        return true;
    }

    private boolean checkSotruong() {
        if (sotruong.isEmpty() || sotruong.equals("")) {
            return false;
        }
        return true;
    }

    private boolean checkcDiaChi() {
        String diachi = mEdtDiaChiHienTai.getText().toString().trim();
        if (diachi.isEmpty() || diachi.equalsIgnoreCase("")) {
            mEdtDiaChiHienTai.setError("Địa chỉ hiện tại không được trống");
            return false;
        }
        return true;
    }

    private boolean checkKhuVuc() {
        String khuvuc = mEdtTenKhuvuc.getText().toString().trim();
        if (khuvuc.isEmpty() || khuvuc.equals("")) {
            mEdtTenKhuvuc.setError("Khu vực  không thể trống");
            return false;
        }
        return true;
    }

    private boolean checkQuan() {
        String quequan = mEdtQueQuan.getText().toString().trim();
        if (quequan.isEmpty() || quequan.equals("")) {
            mEdtQueQuan.setError("Quận không thể trống");
            return false;
        }
        return true;
    }

    private boolean checkEmail() {
        String email = mEdtEmail.getText().toString().trim();
        if (email.isEmpty() || email.equals("")) {
            mEdtEmail.setError("Email không thể trống");
            return false;
        }
        return true;
    }

    private boolean checkSdt() {
        String sdt = mEdtSdt.getText().toString().trim();
        if (sdt.isEmpty() || sdt.equals("")) {
            mEdtSdt.setError("Số điện thoại không thể trống");
            return false;
        }
        return true;
    }


    private boolean checkNgaySinh() {
        String ngaysinh = mEdtNgaySinh.getText().toString().trim();
        if (ngaysinh.isEmpty() || ngaysinh.equals("")) {
            mEdtNgaySinh.setError("Ngày sinh không thể trống");
            return false;
        }
        return true;
    }

    private boolean checkName() {
        String diachi = mEdtName.getText().toString().trim();
        if (diachi.isEmpty() || diachi.equals("")) {
            mEdtName.setError("Tên  không thể trống");
            return false;
        }
        return true;
    }


    private boolean checkQueQuan() {
        String quequan = mEdtQueQuan.getText().toString().trim();
        if (quequan.isEmpty() || quequan.equals("")) {
            mEdtQueQuan.setError("Quê quán không thể trống");
            return false;
        }
        return true;

    }

}
